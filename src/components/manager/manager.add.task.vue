<template>
	<div>
		<div @click="handleclick">
			<el-card shadow="hover" class="qm_radian">
				<i class="el-icon-plus"></i>
			</el-card>
		</div>
		<el-dialog :visible.sync="dialogVisible" title="添加任务" width="30%">
			<el-form :model="addTask" :rules="rules" ref="addTask">
				<el-form-item label="标题" prop="mattername">
					<el-input placeholder="请输入事件名称" v-model="addTask.mattername"></el-input>
				</el-form-item>
				
				<el-form-item label="工作状态" prop="matterstatus">
					<el-radio-group v-model="addTask.matterstatus">
						<el-radio label="nob"></el-radio>
						<el-radio label="ing"></el-radio>
						<el-radio label="end"></el-radio>
					</el-radio-group>
				</el-form-item>

				<el-form-item label="开始时间" prop="begintime">
					<el-date-picker placeholder="选择开始时间" style="width: 100%;" type="datetime" v-model="addTask.begintime">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="预计时间" prop="yujitime">
					<el-date-picker placeholder="选择预计完成时间" style="width: 100%;" type="datetime" v-model="addTask.yujitime">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="完成时间" prop="endtime">
					<el-date-picker placeholder="估算完成时间" style="width: 100%;" type="datetime" v-model="addTask.endtime">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="所属用户名" prop="username">
					<el-input placeholder="请输入事件所属用户名" v-model="addTask.username"></el-input>
				</el-form-item>
				<el-form-item label="事件内容" prop="content">
					<el-input placeholder="请输入事件内容" v-model="addTask.content"></el-input>
				</el-form-item>
				<el-form-item label="用户部门" prop="department">
					<el-radio-group v-model="addTask.department">
						<el-radio label="ceshi"></el-radio>
						<el-radio label="kaifa"></el-radio>
						<el-radio label="xvqiu"></el-radio>
					</el-radio-group>
				</el-form-item>
				
				
				<el-form-item>
					<el-button @click="submitForm('addTask')" type="primary">添加任务</el-button>
					<el-button @click="resetForm('addTask')">重置</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>
	</div>
</template>

<script>
import reques from "@/utils/respone";

export default {
	props: [ "departmentnum"],
	name: "manager-public-add-task.vue",
	data() {
		return {
			dialogVisible: false,
			addTaskList: [],
			savedValue: localStorage.getItem('myDataKey2'),
			addTask: {
				mattername: '',
				matterstatus: '',
				begintime: '',
				yujitime: '',
				endtime: '',
				username: '',
				content:'',
				department: '',
				
			},
			rules: {
				mattername: [{
					required: true,
					message: '请输入任务名称',
					trigger: 'blur'
				}],
				matterstatus: [{
					required: true,
					message: '请输入任务状态',
					trigger: 'blur'
				}],
			
				begintime: [{
					type: 'date',
					required: true,
					message: '请选择开始时间',
					trigger: 'change'
				}],
				yujitime: [{
					type: 'date',
					required: true,
					message: '请选择预计时间',
					trigger: 'change'
				}],
				endtime: [{
					type: 'date',
					required: true,
					message: '请选择完成时间',
					trigger: 'change'
				}],
				username: [{
					required: true,
					message: '请输入任务分配给的用户名',
					trigger: 'blur'
				}],
				department: [{
					required: true,
					message: '请输入该用户的部门',
					trigger: 'blur'
				}],
				content: [{
					required: true,
					message: '请输入任务内容',
					trigger: 'blur'
				}],
				
			}
		}
	},
	methods: {
		handleclick(){
			
			if(this.departmentnum==1){
				this.dialogVisible = true
			}else{
				if(this.savedValue=="admin"){
					this.dialogVisible = true
				}else{
					this.$message.error('暂时无权限新增！')
				}
				
			}
			
		},
		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				// 如果是true就进行数据的传出
				// console.log(valid);
				if (valid) {
					const content=this.addTask.content
					reques.post('/matter/add', {
						mattername: this.addTask.mattername,
						matterstatus: this.addTask.matterstatus,
						begintime: this.addTask.begintime,
						yujitime: this.addTask.yujitime,
						endtime: this.addTask.endtime,
						username: this.addTask.username,
						department: this.addTask.department,
						
					}).then(respone => {
						
						const id=respone.data.data.id
				
						reques.post('/content/addContent',{
							id:id,
							mattercontent:content
						}).then(respone => {

							let str = this.addTask.estimate;
							this.$emit('respones', respone.data.data, str)
						})
					})
					this.$message({
						type: 'success',
						message: '添加成功'
					});
					this.$refs[formName].resetFields();
					this.$emit('refresh');
					
					this.dialogVisible = false;
				} else {
					this.$message({
						type: 'error',
						message: '添加失败'
					});
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
	}
}
</script>

<style scoped>
.qm_radian {
	border-radius: 20px;
}
</style>

<template>
  <div class="card">
    <el-card>
      <div :data-id="title.id"  >
        <el-popconfirm confirm-button-text='确定' cancel-button-text='不用了' icon="el-icon-info" icon-color="red"
          title="确定删除此卡片吗？" @confirm="add(title.id)">
          <el-button style="float: right; padding: 3px 0" class="two el-icon-close" slot="reference"></el-button>
        </el-popconfirm>
        <br>
        <div @click="showText(title.id)">
          事件名称：<span>{{ title.mattername }}</span>
        </div>
          <br>
          <div class="text" v-show="isHovered">
            <div @click="showText(title.id)">
          事件状态：<span>{{ title.matterstatus }}</span>
          <br>
          开始时间：<span>{{ title.begintime }}</span>
          <br>
          预计时间：<span>{{ title.yujitime }}</span>
          <br>
          完成时间：<span>{{ title.endtime }}</span>
          <br>
          所属用户名：<span>{{ title.username }}</span>
          <br>
          用户部门：<span>{{ title.department }}</span>
          <br>  
            </div>
          <el-button type="info" @click="showEditModal(title.id)">修改任务</el-button>
          </div>
        
    </div>
        
    </el-card>
    <el-dialog :visible.sync="showTextModal" title="事件内容" width="30%">
      <div class="text-container">
        {{ text }}
      </div>
      
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="showTextModal = false">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog @close="closefunc" v-if="showModal" :visible.sync="showModal" title="修改任务" width="30%">
			<el-form :model="title" :rules="rules" ref="title">
				<el-form-item label="标题" prop="mattername">
					<el-input placeholder="请输入事件名称" v-model="dataform.mattername"></el-input>
				</el-form-item>
				<el-form-item label="工作状态" prop="matterstatus">
					<el-radio-group v-model="dataform.matterstatus">
						<el-radio label="nob"></el-radio>
						<el-radio label="ing"></el-radio>
						<el-radio label="end"></el-radio>
					</el-radio-group>
				</el-form-item>

				<el-form-item label="开始时间" prop="begintime">
					<el-date-picker placeholder="选择开始时间" style="width: 100%;" type="datetime" v-model="dataform.begintime">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="预计时间" prop="yujitime">
					<el-date-picker placeholder="选择预计完成时间" style="width: 100%;" type="datetime" v-model="dataform.yujitime">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="完成时间" prop="endtime">
					<el-date-picker placeholder="估算完成时间" style="width: 100%;" type="datetime" v-model="dataform.endtime">
					</el-date-picker>
				</el-form-item>
				<el-form-item label="所属用户名" prop="username">
					<el-input placeholder="请输入事件所属用户名" v-model="dataform.username"></el-input>
				</el-form-item>
				<el-form-item label="用户部门" prop="department">
					<el-radio-group v-model="dataform.department">
						<el-radio label="ceshi"></el-radio>
						<el-radio label="kaifa"></el-radio>
						<el-radio label="1"></el-radio>
					</el-radio-group>
				</el-form-item>
        <el-form-item label="事件内容" prop="content">
					<el-input type="textarea"  placeholder="请输入事件内容" v-model="dataform.content"></el-input>
				</el-form-item>
				
				<el-form-item>
					<el-button @click="submitForm('title')" type="primary">修改任务</el-button>
					<el-button @click="resetForm()">重置</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>
    

  </div>
  
</template>

<script>

import axios from 'axios';

export default {
  props: ["title","departmentnum"],
  name: "manager-main-card",
  data() {
    return {
      isHovered:false,
      max: false,
      Arrtys: this.Arrty,
      flag: false,
      text:"",
      showTextModal: false,
      dataform:{
        id:this.title.id,
        mattername:this.title.mattername,
			  matterstatus:this.title.matterstatus,
			  begintime:this.title.begintime,
			  yujitime:this.title.yujitime,
			  endtime:this.title.endtime,
			  username:this.title.username,
        content:'',
			  department:this.title.department
      },
      cardId:'',
      showModal: false, // 控制弹窗的显示状态
    }
  },
  methods: {
    showText(id) {
      axios.get('/content/getByid/'+id).then(respone => {
				this.text=respone.data.data.mattercontent
				
        if(respone.data.result==true){
          this.showTextModal = true; // 显示文本弹窗
        }
			})
      
      
    },
    closefunc(){
      this.dataform.id=this.title.id
      this.dataform.matterstatus=this.title.matterstatus
      this.dataform.mattername=this.title.mattername
      this.dataform.begintime=this.title.begintime
      this.dataform.yujitime=this.title.yujitime
      this.dataform.endtime=this.title.endtime
      this.dataform.username=this.title.username
      this.dataform.department=this.title.department
    },
    resetForm() {
			this.dataform.mattername=''
			this.dataform.matterstatus='',
			this.dataform.begintime='',
			this.dataform.yujitime='',
			this.dataform.endtime='',
			this.dataform.username='',
			this.dataform.department='',
      this.dataform.content=''
		},
    submitForm(formName) {
      
			this.$refs[formName].validate((valid) => {
				// 如果是true就进行数据的传出
				// console.log(valid);
				
					axios.post('/matter/update', {
            id:this.dataform.id,
						mattername: this.dataform.mattername,
						matterstatus: this.dataform.matterstatus,
						begintime: this.dataform.begintime,
						yujitime: this.dataform.yujitime,
						endtime: this.dataform.endtime,
						username: this.dataform.username,
						department: this.dataform.department,
						
					}).then(respone => {
						// console.log(respone.data.data);
						// 将获取的数据传给父组件
            axios.post('/content/updateContent',{
              id:this.dataform.id,
              mattercontent:this.dataform.content
            }).then(respone => {
				      
              let str = this.dataform.estimate;
						  this.$emit('respones', respone.data.data, str)
			      })
						 
					})
					this.$message({
						type: 'success',
						message: '修改成功'
					});
					this.showModal = false;
           this.$refs[formName].resetFields();
           this.$emit('refresh');
           this.$emit('refresh');
				
			});
		},
    updateCardData(){

    },
    showEditModal(id) {
      
      const savedValue = localStorage.getItem('myDataKey2');
      console.log(savedValue)
      if(savedValue=="admin"){
        axios.get('/content/getByid/'+id).then(respone => {
				  this.dataform.content=respone.data.data.mattercontent
			  })
        this.showModal = true;
      }else{
        if(this.departmentnum==1){
          axios.get('/content/getByid/'+id).then(respone => {
				    this.dataform.content=respone.data.data.mattercontent
			    })
          this.showModal = true;
        }else{
          this.$message.error('暂时无权限修改！')
        }
        
      }
      

    },
    // 更新任务数据
    updateCardData(updatedData) {
      this.$emit("updateCard", updatedData); // 将修改后的数据传递给父组件
    },
    
    updatematter(){
      cardId = this.$el.querySelector('[data-id]').getAttribute('data-id');
    },
    // 子传父的值
    events(val) {
      this.max = val
    },
    dateFormat(str) {
      var dateee = new Date(str).toJSON();
      var date = new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '');
      return date;
    },
    // 点击改变得值
    updata() {
      this.max = true

    },
    add(val) {
      const savedValue = localStorage.getItem('myDataKey2');
      console.log(savedValue)
      if(savedValue=="admin"){
        this.$emit("remove", val);
        
      }else{
        if(this.departmentnum==1){
          this.$emit("remove", val);
        }else{
          this.$message.error('暂时无权限删除！')
        }
        
      }
      
    },
    onconfirm() {
      this.visible = false;
      this.$emit("onconfirm");
    },
    oncancel() {
      this.visible = false;
      this.$emit("oncancel");
    }
  },

  mounted() {
    // 监听鼠标悬停事件
    this.$el.addEventListener('mouseover', () => {
      this.isHovered = true;
    });
    this.$el.addEventListener('mouseout', () => {
      this.isHovered = false;
    });
    updatematter()
  
    
  }
}

</script>

<style lang="less" scoped>
.one {
  font-weight: bold;
  text-align: center;
}


.two {
  width: 60px;
  
  transition: all 0.15s ease;
}
.text-container {
  border: 1px solid #DCDFE6; /* 边框颜色 */
  padding: 10px; /* 内边距 */
  margin-bottom: 20px; /* 下边距 */
}
.el-button {
  border: 0px;
}

// .text {
//   font-size: 18px;
//   line-height: 1em;
//   text-align: left;
//   font-family: 楷体;
//   font-weight: bold;
// }

p {
  line-height: 37px;
}



.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.editmatter {
  width: 100%;
  height: 100%;
}

.clearfix:after {
  clear: both;
}

/deep/ .box-card {
  background-color: #FAF9DE;
  border-radius: 20px;
}
.el-card {
  width: 300px; /* 或者您希望的任何固定宽度 */
  overflow: hidden; /* 或者 auto */
}

/* 设置悬浮时显示的内容的最大宽度 */
.text {
  max-width: 100%; /* 确保不会超出卡片宽度 */
}

</style>
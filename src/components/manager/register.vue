<template>
  <el-container>
    <el-main>
      <div class="tspo">
        <div class="mont">
          <div class="crt">
            <p>Welcome</p>
            <div>看板系统注册界面</div>
          </div>
        </div>
        <el-form ref="form" label-width="65px" class="rotp">
          <div style="margin-top: 100px">
            <el-form-item>
              <el-input prefix-icon="el-icon-user-solid " v-model.trim="text" placeholder="请输入账号" clearable
                @keyup.enter.native="keyupTest"></el-input>
            </el-form-item>
            <el-form-item>
              <el-input prefix-icon="el-icon-lock" v-model.trim="password" show-password placeholder="请输入密码" clearable
                @keyup.enter.native="keyupTest"></el-input>
            </el-form-item>
            <el-form-item>
              <el-input prefix-icon="el-icon-lock" v-model.trim="surepassword" show-password placeholder="请确认密码" clearable
                @keyup.enter.native="keyupTest"></el-input>
            </el-form-item>
            <el-form-item label="部门:" >
              <el-radio-group v-model.trim="department">
                <el-radio label="ceshi"></el-radio>
                <el-radio label="kaifa"></el-radio>
                <el-radio label="1"></el-radio>
              </el-radio-group>
            </el-form-item>
            

            
            <el-form-item style="margin-left: 50px">
              <el-button type="primary" @click="skip">注册</el-button>
            </el-form-item>
            <div class="qm_aegi">
              <span>已有账号？</span>
              <router-link to="/login">
                <el-link :underline="false" type="primary">登录账号</el-link>
              </router-link>
            </div>
          </div>
        </el-form>
      </div>
    </el-main>
  </el-container>
</template>

<script>
import reques from '@/utils/respone.js'
export default {
  name: 'register',
  data() {
    return {
      text: '',
      department:'',
      surepassword:'',
      password: '',
      verification: '',
      checked: false,
      checkeds: ''
    }
  },
  methods: {
    // 页面刷新自动获取数据并且进行渲染
    addstore() {
      // 获取到本地数据的值
      let username = localStorage.getItem("username")
      let passworde = localStorage.getItem("password")
      let checkedse = localStorage.getItem("checked")
      if (username || passworde || checkedse) {
        this.text = username
        this.password = passworde
        this.checked = true
      }
    },

    // 用户表数据调用
    skip() {
      console.log(this.text)
      console.log(this.password)
      console.log(this.surepassword)
      console.log(this.department)
      if (this.password == ''|| this.password==null||this.surepassword==null
          ||this.surepassword==''||this.text==null || this.text == ''
          ||this.department==''||this.department==null) {
        this.$message.error('请输入所有信息！')
        return
      }
      if(this.password!=this.surepassword){
        console.log("mima")
        this.$message.error('两次输入的密码不一致！')
        this.text=''
        this.password=''
        this.surepassword=''
        this.department=''
        return
      }
      reques
        .post('/login/register', {
          username: this.text,
          password: this.password
        })
        .then(res => {
          if (res.data.result == true) {
            reques
              .get('/user/register/'+this.text+'/'+this.department )
              .then(res => {
                if (res.data.result == true) {
                  this.$message.success('注册成功！')
                  this.$router.replace('./login')

                } else {
                  this.$message.error('注册失败！')
                }
              })
              .catch(error => {
                this.$message.error('数据错误')
              })
          } else {
            console.log("cunzia")
            this.$message.error('用户名已存在！')
            this.text=''
            this.password=''
            this.surepassword=''
            this.department=''
          }
        })
        .catch(error => {
          this.$message.error('数据错误')
        })
    },
    // 回车事件
    keyupTest() {
      this.skip()
    }
  },
  created() {
    this.addstore()
  },
}
</script>

<style lang="less" scoped>
@media screen and (max-width:1440px) {
  .el-container {
    width: 1440px;
  }
}

.el-container {
  height: 100%;
  background-size: 100% 100%;
}

.el-checkbox {
  margin-left: 35px;
}

.el-main {
  display: flex;
  justify-content: center;
  height: 100%;

  .tspo {
    display: flex;
    justify-content: center;
    align-items: center;

    .rotp {
      width: 430px;
      height: 480px;
      background: white;

      // 注册账号效果
      .qm_aegi {
        display: flex;
        justify-content: center;
      }

      .inp {
        width: 60%;
      }

      .miten {
        margin-left: -50px;
      }

      .el-input {
        left: -50px;

        /deep/ .el-input__inner {
          border: 0px;
          border-bottom: 1px solid #dcdfe6;
        }
      }
    }

    .top_lis {
      display: flex;
      justify-content: space-between;

      :nth-child(2) {
        margin-right: 50px;
      }
    }

    .mont {
      width: 430px;
      height: 480px;
      border-radius: 4px;
      background-color: rgba(255, 255, 248, 0.5);
      text-align: center;

      .crt {
        margin-top: 73px;
      }

      :nth-child(1) {
        font-size: 40px;
        //background-clip: text;
        color: transparent;
        background-image: linear-gradient(120deg, #30cfd0 0%, #ebbba7 50%, #a3bded 80%);
      }

      :nth-child(2) {
        font-size: 50px;
        //background-clip: text;
        color: transparent;
        background-image: linear-gradient(-90deg, #29be0e 0%, #276ace 100%);
      }
    }
  }
}

.el-button--primary {
  width: 200px;
  border-radius: 30px;
  background-image: linear-gradient(-90deg, #29bdd9 0%, #276ace 100%);
}

h1 {
  font-size: 50px;
  text-align: center;
}

.el-card__body {
  margin-top: 25px;
}

.el-form-item {
  margin-top: 50px;
}
</style>

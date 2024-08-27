<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"440rpx 44rpx 244rpx 44rpx","background":"url(http://clfile.zggen.cn/20240116/83a74ba2202d4f169bb06d4b4e4a3dbc.jpg) no-repeat center top / 100%,#ffffff","height":"auto"}'>
		<view :style='{"padding":"48rpx 48rpx 48rpx 48rpx","boxShadow":"0px 0px 12rpx #dddddd","margin":"0 0 244rpx 0","borderRadius":"4rpx","background":"#ffffff","display":"block","width":"100%","position":"relative","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 0 40rpx 0","borderRadius":"100%","objectFit":"cover","display":"none","height":"80rpx"}' src="http://clfile.zggen.cn/20231027/f76234bafa534579beeb9a486c2d2df2.jpg" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.yishengzhanghao" type="text" class="uni-input" name="" placeholder="医生账号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.yishengmima" type="password" class="uni-input" name="" placeholder="医生密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.yishengmima2" type="password" class="uni-input" name="" placeholder="确认医生密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.yishengxingming" type="text" class="uni-input" name="" placeholder="医生姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yisheng'" @tap="yishengzhaopianTap" class="">
                <view>请上传照片</view>
                <image :style='{"width":"160rpx","borderRadius":"0px","objectFit":"contain","display":"block","height":"120rpx"}' v-if="ruleForm.zhaopian" class="avator" :src="baseUrl+ruleForm.zhaopian" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"0px","objectFit":"contain","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"border":"2rpx solid #00000010","padding":"0 20rpx","margin":"0 0 24rpx 0","borderRadius":"0px","background":"#ffffff","width":"100%","height":"auto"}' v-if="tableName=='yisheng'"  @change="yishengxingbieChange" :value="yishengxingbieIndex" :range="yishengxingbieOptions">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#999999"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.lianxidianhua" type="text" class="uni-input" name="" placeholder="联系电话" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.shanzhanglingyu" type="text" class="uni-input" name="" placeholder="擅长领域" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.keshi" type="text" class="uni-input" name="" placeholder="科室" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='yisheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.zhicheng" type="text" class="uni-input" name="" placeholder="职称" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.huanzhezhanghao" type="text" class="uni-input" name="" placeholder="患者账号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.huanzhemima" type="password" class="uni-input" name="" placeholder="患者密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.huanzhemima2" type="password" class="uni-input" name="" placeholder="确认患者密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.huanzhexingming" type="text" class="uni-input" name="" placeholder="患者姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='huanzhe'" @tap="huanzhetouxiangTap" class="">
                <view>请上传头像</view>
                <image :style='{"width":"160rpx","borderRadius":"0px","objectFit":"contain","display":"block","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"0px","objectFit":"contain","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"border":"2rpx solid #00000010","padding":"0 20rpx","margin":"0 0 24rpx 0","borderRadius":"0px","background":"#ffffff","width":"100%","height":"auto"}' v-if="tableName=='huanzhe'"  @change="huanzhexingbieChange" :value="huanzhexingbieIndex" :range="huanzhexingbieOptions">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#999999"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.shoujihaoma" type="text" class="uni-input" name="" placeholder="手机号码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='huanzhe'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.nianling" type="text" class="uni-input" name="" placeholder="年龄" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='peizhenyuan'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.peizhenyuanzhanghao" type="text" class="uni-input" name="" placeholder="陪诊员账号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='peizhenyuan'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.denglumima" type="password" class="uni-input" name="" placeholder="登录密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='peizhenyuan'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.denglumima2" type="password" class="uni-input" name="" placeholder="确认登录密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='peizhenyuan'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.peizhenyuanxingming" type="text" class="uni-input" name="" placeholder="陪诊员姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='peizhenyuan'" @tap="peizhenyuanzhaopianTap" class="">
                <view>请上传照片</view>
                <image :style='{"width":"160rpx","borderRadius":"0px","objectFit":"contain","display":"block","height":"120rpx"}' v-if="ruleForm.zhaopian" class="avator" :src="baseUrl+ruleForm.zhaopian" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"0px","objectFit":"contain","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='peizhenyuan'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.zhiweileixing" type="text" class="uni-input" name="" placeholder="职位类型" />
			</view>
			<picker :style='{"border":"2rpx solid #00000010","padding":"0 20rpx","margin":"0 0 24rpx 0","borderRadius":"0px","background":"#ffffff","width":"100%","height":"auto"}' v-if="tableName=='peizhenyuan'"  @change="peizhenyuanxingbieChange" :value="peizhenyuanxingbieIndex" :range="peizhenyuanxingbieOptions">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#999999"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='peizhenyuan'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.lianxidianhua" type="text" class="uni-input" name="" placeholder="联系电话" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='peizhenyuan'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #00000010","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#999999","borderRadius":"0px","background":"#ffffff","width":"100%","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.storeupnum" type="text" class="uni-input" name="" placeholder="收藏数量" />
			</view>
			<button :style='{"border":"0px solid #dddddd","padding":"0 0 0 0","margin":"0 0 24rpx 0","color":"#fff","borderRadius":"0px","background":"#ff9933","width":"100%","lineHeight":"80rpx","fontSize":"30rpx","height":"80rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                yishengxingbieOptions: [],
                yishengxingbieIndex: 0,
                huanzhexingbieOptions: [],
                huanzhexingbieIndex: 0,
                peizhenyuanxingbieOptions: [],
                peizhenyuanxingbieIndex: 0,
				ruleForm: {
                yishengzhanghao: '',
                yishengmima: '',
                yishengxingming: '',
                zhaopian: '',
                xingbie: '',
                lianxidianhua: '',
                shanzhanglingyu: '',
                keshi: '',
                zhicheng: '',
                huanzhezhanghao: '',
                huanzhemima: '',
                huanzhexingming: '',
                touxiang: '',
                xingbie: '',
                shoujihaoma: '',
                nianling: '',
                peizhenyuanzhanghao: '',
                denglumima: '',
                peizhenyuanxingming: '',
                zhaopian: '',
                zhiweileixing: '',
                xingbie: '',
                lianxidianhua: '',
                storeupnum: '0',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

			// 自定义下拉框值
			if(this.tableName=='yisheng'){
                this.yishengxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yishengxingbieOptions[0]
			}
			// 自定义下拉框值
			if(this.tableName=='huanzhe'){
                this.huanzhexingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.huanzhexingbieOptions[0]
			}
			// 自定义下拉框值
			if(this.tableName=='peizhenyuan'){
                this.peizhenyuanxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.peizhenyuanxingbieOptions[0]
			}
            if(`peizhenyuan` == this.tableName){
                this.ruleForm.storeupnum='0'
            }
			
			this.styleChange()
		},
		methods: {

            yishengzhaopianTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.zhaopian = 'file/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            yishengxingbieChange(e) {
                    this.yishengxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yishengxingbieOptions[this.yishengxingbieIndex]
            },
            huanzhetouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'file/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            huanzhexingbieChange(e) {
                    this.huanzhexingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.huanzhexingbieOptions[this.huanzhexingbieIndex]
            },
            peizhenyuanzhaopianTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.zhaopian = 'file/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            peizhenyuanxingbieChange(e) {
                    this.peizhenyuanxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.peizhenyuanxingbieOptions[this.peizhenyuanxingbieIndex]
            },
            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					document.querySelectorAll('.radioText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.radioTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#ff9933","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#999999"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#ff9933"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #cccccc","outlineColor":"#666666","background":"#ffffff","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #ff9933","textAlign":"center","background":"#fff","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #cccccc","borderColor":"#666666","borderRadius":"0px","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"borderColor":"#ff9933","color":"#ff9933","borderRadius":"0px","background":"#fff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				if((!this.ruleForm.yishengzhanghao) && `yisheng` == this.tableName){
					this.$utils.msg(`医生账号不能为空`);
					return
				}
				if((!this.ruleForm.yishengmima) && `yisheng` == this.tableName){
					this.$utils.msg(`医生密码不能为空`);
					return
				}
                if(`yisheng` == this.tableName && (this.ruleForm.yishengmima!=this.ruleForm.yishengmima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.yishengxingming) && `yisheng` == this.tableName){
					this.$utils.msg(`医生姓名不能为空`);
					return
				}
				if(`yisheng` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if((!this.ruleForm.huanzhezhanghao) && `huanzhe` == this.tableName){
					this.$utils.msg(`患者账号不能为空`);
					return
				}
				if((!this.ruleForm.huanzhemima) && `huanzhe` == this.tableName){
					this.$utils.msg(`患者密码不能为空`);
					return
				}
                if(`huanzhe` == this.tableName && (this.ruleForm.huanzhemima!=this.ruleForm.huanzhemima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.huanzhexingming) && `huanzhe` == this.tableName){
					this.$utils.msg(`患者姓名不能为空`);
					return
				}
				if(`huanzhe` == this.tableName && this.ruleForm.shoujihaoma&&(!this.$validate.isMobile(this.ruleForm.shoujihaoma))){
					this.$utils.msg(`手机号码应输入手机格式`);
					return
				}
                if(`peizhenyuan` == this.tableName && (this.ruleForm.denglumima!=this.ruleForm.denglumima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`peizhenyuan` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if(`peizhenyuan` == this.tableName && this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数量应输入整数`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>

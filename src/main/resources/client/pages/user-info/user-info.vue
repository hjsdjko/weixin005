<template>
<view class="content">
	<view class="box" :style='{"width":"100%","padding":"0 0 0 0","position":"relative","background":"#ff993310","height":"100%"}'>
		<view :style='{"width":"100%","padding":"24rpx 24rpx 24rpx 24rpx","background":"none","display":"block","height":"auto"}'>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>医生账号</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}' disabled="true"  v-model="ruleForm.yishengzhanghao" placeholder="医生账号"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>医生姓名</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.yishengxingming" placeholder="医生姓名"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" @tap="yishengzhaopianTap" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>照片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.zhaopian" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.zhaopian" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view v-if="tableName=='yisheng'" :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="yishengxingbieChange" :value="yishengxingbieIndex" :range="yishengxingbieOptions">
					<view :style='{"border":"2rpx solid #eeeeee","padding":"0 20rpx","color":"#888888","background":"#ffffff","width":"100%","lineHeight":"64rpx","fontSize":"28rpx"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>联系电话</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.lianxidianhua" placeholder="联系电话"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>擅长领域</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.shanzhanglingyu" placeholder="擅长领域"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>科室</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.keshi" placeholder="科室"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yisheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>职称</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.zhicheng" placeholder="职称"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>患者账号</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}' disabled="true"  v-model="ruleForm.huanzhezhanghao" placeholder="患者账号"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>患者姓名</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.huanzhexingming" placeholder="患者姓名"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" @tap="huanzhetouxiangTap" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view v-if="tableName=='huanzhe'" :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="huanzhexingbieChange" :value="huanzhexingbieIndex" :range="huanzhexingbieOptions">
					<view :style='{"border":"2rpx solid #eeeeee","padding":"0 20rpx","color":"#888888","background":"#ffffff","width":"100%","lineHeight":"64rpx","fontSize":"28rpx"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>手机号码</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.shoujihaoma" placeholder="手机号码"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='huanzhe'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>年龄</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.nianling" placeholder="年龄"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='peizhenyuan'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>陪诊员账号</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}' disabled="true"  v-model="ruleForm.peizhenyuanzhanghao" placeholder="陪诊员账号"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='peizhenyuan'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>陪诊员姓名</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.peizhenyuanxingming" placeholder="陪诊员姓名"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='peizhenyuan'" @tap="peizhenyuanzhaopianTap" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>照片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.zhaopian" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.zhaopian" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='peizhenyuan'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>职位类型</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.zhiweileixing" placeholder="职位类型"></input>
			</view>
			<view v-if="tableName=='peizhenyuan'" :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="peizhenyuanxingbieChange" :value="peizhenyuanxingbieIndex" :range="peizhenyuanxingbieOptions">
					<view :style='{"border":"2rpx solid #eeeeee","padding":"0 20rpx","color":"#888888","background":"#ffffff","width":"100%","lineHeight":"64rpx","fontSize":"28rpx"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='peizhenyuan'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>联系电话</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.lianxidianhua" placeholder="联系电话"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 0","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"0px","background":"none","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='peizhenyuan'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#666","textAlign":"right"}'>收藏数量</view>
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#fff","fontSize":"28rpx","height":"64rpx"}'   v-model="ruleForm.storeupnum" placeholder="收藏数量"></input>
			</view>
			<view :style='{"width":"100%","margin":"40rpx 0 0 0","justifyContent":"center","display":"flex","height":"auto"}' class="btn">
				<button @tap="update()" class="cu-btn lg" :style='{"border":"0","padding":"0 0 0 0","margin":"0 20rpx 0 20rpx","color":"#fff","borderRadius":"40rpx","background":"#ff9933","width":"240rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}'>保存</button>
				<button @tap="logout()" class="cu-btn lg" :style='{"border":"0","padding":"0 0 0 0","margin":"0 20rpx 0 20rpx","color":"#333","borderRadius":"40rpx","background":"#ff993330","width":"240rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}'>退出登录</button>
			</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				ruleForm: {
				},
				tableName:"",
				yishengxingbieOptions: [],
				yishengxingbieIndex: 0,
				huanzhexingbieOptions: [],
				huanzhexingbieIndex: 0,
				peizhenyuanxingbieOptions: [],
				peizhenyuanxingbieIndex: 0,
			}
		},
        components: {
            multipleSelect
        },
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad() {
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.ruleForm = res.data;
			this.tableName = table;
			// 自定义下拉框值
			if(this.tableName=='yisheng'){
				this.yishengxingbieOptions = "男,女".split(',');
				this.yishengxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.yishengxingbieIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='huanzhe'){
				this.huanzhexingbieOptions = "男,女".split(',');
				this.huanzhexingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.huanzhexingbieIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='peizhenyuan'){
				this.peizhenyuanxingbieOptions = "男,女".split(',');
				this.peizhenyuanxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.peizhenyuanxingbieIndex = index;
					}
				});
			}
			this.styleChange()
            this.$forceUpdate()
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
					  const icon = {"color":"#666666"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.radioTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#ff9933"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666"}
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
					  const icon = {"border":"2rpx solid #999999","borderRadius":"0","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #ff9933","borderRadius":"0","color":"#ff9933","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #999999","borderRadius":"0","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #ff9933","color":"#ff9933","borderRadius":"0","background":"#ffffff"}
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
			logout() {
				uni.clearStorageSync()
				uni.reLaunch({
					url:'/pages/index/index'
				})
			},
			
			// 注册
			async update() {
				if((!this.ruleForm.yishengzhanghao) && `yisheng` == this.tableName){
					this.$utils.msg(`医生账号不能为空`);
					return
				}
				if((!this.ruleForm.yishengmima) && `yisheng` == this.tableName){
					this.$utils.msg(`医生密码不能为空`);
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
				if((!this.ruleForm.huanzhexingming) && `huanzhe` == this.tableName){
					this.$utils.msg(`患者姓名不能为空`);
					return
				}
				if(`huanzhe` == this.tableName && this.ruleForm.shoujihaoma&&(!this.$validate.isMobile(this.ruleForm.shoujihaoma))){
					this.$utils.msg(`手机号码应输入手机格式`);
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
				let table = uni.getStorageSync("nowTable");
				await this.$api.update(table, this.ruleForm);
				this.$utils.msgBack('修改成功');;
			},

		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>

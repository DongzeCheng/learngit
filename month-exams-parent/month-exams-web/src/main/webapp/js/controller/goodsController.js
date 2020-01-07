/**
 * 
 */
app.controller('goodsController',function($scope,goodsService,uploadService){
	$scope.entity={}
	
	$scope.getList=function(){
		goodsService.getList().success(function(re) {
			$scope.list=re;
		})
	}
	
	$scope.upload=function(){
		uploadService.upload().success(function(re) {
			if (re.success) {
				alert("上传成功");
				$scope.entity.url=re.message;
			}else{
				alert(re.message);
			}
		})
	}
	
	$scope.save=function(){
		goodsService.save($scope.entity).success(function(re) {
			if (re.success) {
				alert(re.message);
				location.href="/goods.html";
			}else{
				alert(re.message);
			}
		})
	}
	
	$scope.up=function(id){
		goodsService.up(id).success(function(re) {
				location.href="/goods.html";
		})
	}
	
	$scope.dwon=function(id){
		goodsService.dwon(id).success(function(re) {
				location.href="/goods.html";
		})
	}
})
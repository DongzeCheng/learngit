/**
 * 
 */
app.controller('orderController',function($scope,$location,orderService){
	$scope.entity={}
	$scope.entitys={}
	
	$scope.back=function(){
		var id = $location.search()['id'];
		orderService.back(id).success(function (re) {
			console.log(re)
			$scope.entity=re;
		})
	}
	
	$scope.save=function(){
		orderService.save($scope.entitys).success(function (re) {
			if (re.success) {
				alert(re.message)
				location.href="/order.html"
			}else{
				alert(re.message)
			}
		})
	}
})
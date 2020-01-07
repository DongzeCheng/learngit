/**
 * 
 */
app.service('orderService',function($http){
	this.back=function(id){
		return $http.get('../order/back.do?id='+id)
	}
	
	this.save=function(entitys){
		return $http.post('../order/save.do',entitys)
	}
})
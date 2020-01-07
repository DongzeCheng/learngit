/**
 * 
 */
app.service('goodsService',function($http){
	this.getList=function(){
		return $http.get('../goods/getList.do');
	}
	
	this.save=function(entity){
		return $http.post('../goods/save.do',entity);
	}
	
	this.up=function(id){
		return $http.get('../goods/up.do?id='+id);
	}
	
	this.dwon=function(id){
		return $http.get('../goods/dwon.do?id='+id);
	}
})
var SquareControllerModule = (function(){
	
	var loadResponse = function () {
		axios.get('/square?value='+window.location.search.substring(1).split('=')[1])
		.then(function(response){
			document.getElementById('response').innerHTML = response.data;
		})
		.catch(function(error){
			console.log(error);
		});
		
	} 

	return {
		loadResponse: loadResponse
	};
})();
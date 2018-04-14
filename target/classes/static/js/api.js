var SquareControllerModule = (function(){
	var loadResponse = function (){
		axios.get('/square?value='+document+getElementById('value').value)
		.then(response)
	};
})();
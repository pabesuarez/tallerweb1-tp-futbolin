
function convertir(){
	var t = document.getElementById("direccion").value
	axios.get('https://maps.googleapis.com/maps/api/geocode/json',{
			params:{
				address: t,
				key:'AIzaSyCQcuUY-mwQFcy6akUSXAh7Of7kBwZnSEA'
			}
	})
	.then(function(response){
		console.log(response);
		document.getElementById("valor").innerText="latitud:"+response.data.results[0].geometry.location.lat+" longitud:"+response.data.results[0].geometry.location.lng;
	})
}
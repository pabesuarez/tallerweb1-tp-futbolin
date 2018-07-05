
function initMap(){
	
	var t = document.getElementById("direccion").value
	axios.get('https://maps.googleapis.com/maps/api/geocode/json',{
			params:{
				address: t,
				key:'AIzaSyCQcuUY-mwQFcy6akUSXAh7Of7kBwZnSEA'
			}
	})
	.then(function(response){
		var lat=response.data.results[0].geometry.location.lat;
		var lng=response.data.results[0].geometry.location.lng;
		var ubicacion = {lat: lat, lng: lng};
		console.log(ubicacion);
		document.getElementById("latitud").value=lat;
		document.getElementById("longitud").value=lng;
		
		var map = new google.maps.Map(
		document.getElementById('map'), {zoom: 16, center: ubicacion});
		var marker = new google.maps.Marker({position: ubicacion, map: map});
	})
}


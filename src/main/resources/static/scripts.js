 //map options
    function initMap(){
    var options ={
    zoom:8,
    center:{lat:38.635357},lng:-90.20099}
    }
// New map
    var map = new google.maps.Map(document.getElementById('map), options);

//  Add marker
    var marker = new google.maps.Marker({
    position:{lat:38.61278, lng:-90.25954},
    map:map
    }):

    async
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDT-YbQAN99EBfnKlMsomBaVDfvtC0LLZkY&callback=initMap">

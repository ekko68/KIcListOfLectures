function openmap(div,locationx,locationy,num,zoom){   
	    var mymap = L.map(div).setView([locationx, locationy], num);
	    
	    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
	        maxZoom: zoom,
	        attribution: '© <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
	    }).addTo(mymap);        
}
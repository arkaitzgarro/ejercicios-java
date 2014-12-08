/**
 * Load data from REST service
 */
$(document).ready(function(){
	'use strict';
	
	var $btn = $('#get-data'),
		$table = $('table tbody'),
		$tpl = $('#row-template').html();
	
	$btn.on('click', function(e){
		$(this).button('loading');
		
		$.ajax('http://localhost:8080/RESTServlets/film', {
			dataType: 'json',
			success: function(data) {
				if (data.length) {
					for (var i = 0; i < data.length; i++) {
						var film = data[i];
						
						console.log(film);
						
						var $row = $tpl.replace('__id__', film['id'])
									   .replace('__title__', film['title'])
									   .replace('__description__', film['description'])
									   .replace('__year__', film['year']);
						
						$table.append($row);
					}
				}
				
				$btn.button('reset');
			}
		});
	});
});
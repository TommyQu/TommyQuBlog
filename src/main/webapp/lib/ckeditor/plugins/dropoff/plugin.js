'use strict';

( function() {
	CKEDITOR.plugins.add('dropoff', {
	     init: function (editor) {

	          function regectDrop(event) {
	              event.data.preventDefault(true);
	          };

	          editor.on('contentDom', function() {
	            editor.document.on('drop',regectDrop);
	          });

	      }
	});
} )();

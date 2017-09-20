var $ = require('jquery');
    $(document).ready( function() {
        $(document).on('change', ':file', function() {
            var input = $(this),
                numFiles = input.get(0).files ? input.get(0).files.length : 1,
                label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
           input.trigger('fileselect', [numFiles, label]);
            input.parent().parent().parent().children("input").val(label);
        });
    })

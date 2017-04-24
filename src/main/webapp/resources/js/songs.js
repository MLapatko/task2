$(document).ready(function () {

    var actionType="showAll";

    $.ajax(location.href, {
        method: 'get',
        data: {actionType: actionType},
        success: function (result) {
            var newData = JSON.parse(JSON.stringify(result));
            Object.keys(newData).forEach(function (key1) {
                var value = JSON.parse(newData[key1]);
                $("tbody").append('<tr class="data"><td data-name="id">'
                    +value.id+'</td><td data-name="name">'
                    +value.name+'</td><td data-name="composer">'
                    +value.composer+'</td><td data-name="time">'
                    +value.time+'</td><td data-name="wordsAuther">'
                    +value.wordsAuther+'</td><td data-name="singer">'
                    +value.singer+'</td><td data-name="accompaniment">'
                    + value.accompaniment+'</td><td data-name="vocalType">'
                    +value.vocalType+'</td><td data-name="status">'
                    +value.status+'</td><td><button class="js-action-add-to-disk" data-song-key="'
                    +value.id+ '" data-song-status-on="on">Добавить</button></td><td>' +
                    '<button class="js-action-delete-from-disk" data-song-key="'
                    +value.id +'" data-song-status-off="off">Удалить</button></td></tr>');
            });
        }
    });

    $('.js-action-search-singer').on('click', function () {

        var self = $(this);
        var sortParameter=$("input:text").val();;
        var actionType="sortSinger";
        $.ajax(location.href, {
            method: 'get',
            data: {parameter: sortParameter, actionType: actionType},
            success: function (result) {
                var newData = JSON.parse(JSON.stringify(result));
                var arr = [];
                for (var prop in newData) {
                    var value = JSON.parse(newData[prop]);
                    arr.push(value.id.toString());
                }
                console.log(arr);
                var $tr = $("tbody").find('.data');

                $.each($tr, function(index) {
                    if (jQuery.inArray($('.data:eq('+index+') .js-action-add-to-disk').attr('data-song-key'),arr)==-1)
                    {
                        $(this).hide();
                    }
                });
            }
        })
    });

    $(document).on('click', '.js-action-add-to-disk', function () {
        alert("add to disk");
        var self = $(this);
        var keyValue = self.attr('data-song-key');
        var statusValue =self.attr('data-song-status-on');
        console.log($(this));
        $.ajax(location.href, {
            method: 'post',
            data: {key: keyValue, status: statusValue},
            success: function (result) {
                self.closest('tr').children('td[data-name=status]').text(result);
            }
        });
    });

    $(document).on('click','.js-action-delete-from-disk', function () {

        var self = $(this);
        var keyValue = self.attr('data-song-key');
        var statusValue =self.attr('data-song-status-off');
        $.ajax(location.href, {
            method: 'post',
            data: {key: keyValue, status: statusValue},
            success: function (result) {
                self.closest('tr').children('td[data-name=status]').text(result);
            }
        });
    });
    $('.js-action-sort-name').on('click', function () {

        var self = $(this);
        var sortParameter="name";
        var actionType="sort";
        $.ajax(location.href, {
            method: 'get',
            data: {parameter: sortParameter, actionType: actionType},
            success: function (result) {
                var newData = JSON.parse(JSON.stringify(result));
                Object.keys(newData).forEach(function (key1) {
                    var value = JSON.parse(newData[key1]);
                    $('.data:eq('+key1+')').children('td[data-name]:eq(0)').text(value.id);
                    $('.data:eq('+key1+')').children('td[data-name]:eq(1)').text(value.name);
                    $('.data:eq('+key1+')').children('td[data-name]:eq(2)').text(value.composer);
                    $('.data:eq('+key1+')').children('td[data-name]:eq(3)').text(value.time);
                    $('.data:eq('+key1+')').children('td[data-name]:eq(4)').text(value.wordsAuther);
                    $('.data:eq('+key1+')').children('td[data-name]:eq(5)').text(value.singer);
                    $('.data:eq('+key1+')').children('td[data-name]:eq(6)').text(value.accompaniment);
                    $('.data:eq('+key1+')').children('td[data-name]:eq(7)').text(value.vocalType);
                    $('.data:eq('+key1+')').children('td[data-name]:eq(8)').text(value.status);
                    console.log($('.data:eq('+key1+') .js-action-add-to-disk'));
                    $('.data:eq('+key1+') .js-action-add-to-disk').attr('data-song-key', value.id);
                    $('.data:eq('+key1+') .js-action-delete-from-disk').attr('data-song-key', value.id);

                });
            }
        });
    });
    $('#solomusic').DataTable();
});
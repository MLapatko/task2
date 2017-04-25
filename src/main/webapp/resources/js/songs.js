$(document).ready(function () {

    showTable("#solo");
    showTable("#chorus");

    function showTable(idTable) {
        $.ajax(location.href, {
            method: 'get',
            data: {actionType: "showAll",id: idTable},
            success: function (result) {
                var newData = JSON.parse(JSON.stringify(result));
                Object.keys(newData).forEach(function (key1) {
                    var value = JSON.parse(newData[key1]);
                    var type;
                    if(idTable==="#solo"){
                        type=value.vocalType;
                    }
                    else {
                        type=value.chorusType;
                    }
                    $(""+idTable+" tbody").append('<tr class="data"><td data-name="id">'
                        +value.id+'</td><td data-name="name">'
                        +value.name+'</td><td data-name="composer">'
                        +value.composer+'</td><td data-name="time">'
                        +value.time+'</td><td data-name="wordsAuther">'
                        +value.wordsAuther+'</td><td data-name="singer">'
                        +value.singer+'</td><td data-name="accompaniment">'
                        + value.accompaniment+'</td><td data-name="vocalType">'
                        +type+'</td><td data-name="status">'
                        +value.status+'</td><td><button class="js-action-add-to-disk" data-song-key="'
                        +value.id+ '" data-song-status-on="on">Добавить</button></td><td>' +
                        '<button class="js-action-delete-from-disk" data-song-key="'
                        +value.id +'" data-song-status-off="off">Удалить</button></td></tr>');
                });
            }
        });
    }


    $('.js-action-search-singer').on('click', function () {
            var self = $(this);
            var sortParameter=$("input:text").val();
            var actionType="sortSinger";
            $.ajax(location.href, {
                method: 'get',
                data: {parameter:sortParameter,actionType: actionType},
                success: function (result) {
                    var newData = JSON.parse(JSON.stringify(result));
                    var arr = [];
                    for (var prop in newData) {
                        var value = JSON.parse(newData[prop]);
                        arr.push(value.id.toString());
                    }
                    var $tr = $("tbody").find('.data');
                    console.log($tr);
                    $.each($tr, function(index) {
                        if (jQuery.inArray($('.data:eq('+index+') .js-action-add-to-disk').attr('data-song-key'),arr)==-1)
                        {
                            $(this).hide();
                        }
                    });
                }
            })
    });

    $('.js-action-add-to-disk').on('click', function () {
        var tableId=$(this).closest('table').attr('id');
        var self = $(this);
        var keyValue = self.attr('data-song-key');
        var statusValue =self.attr('data-song-status-on');
        $.ajax(location.href, {
            method: 'post',
            data: {key: keyValue, status: statusValue,id: tableId},
            success: function (result) {
                self.closest('tr').children('td[data-name=status]').text(result);
            }
        });
    });
    $('.js-action-calculate-time').on('click', function () {
        var self = $(this);
        var actionType="calculateTime";
        $.ajax(location.href, {
            method: 'get',
            data: {actionType: actionType},
            success: function (result) {
                var newData = result;
                alert(newData);
            }
        });
    });

    $('.js-action-delete-from-disk').on('click', function () {
        var tableId=$(this).closest('table').attr('id');
        var self = $(this);
        var keyValue = self.attr('data-song-key');
        var statusValue =self.attr('data-song-status-off');
        $.ajax(location.href, {
            method: 'post',
            data: {key: keyValue, status: statusValue,id:tableId},
            success: function (result) {
                self.closest('tr').children('td[data-name=status]').text(result);
            }
        });
    });
    $('.js-action-sort-name').on('click', function () {
        var self = $(this);
        var tables= $("table")
        Array.from(document.getElementsByClassName('display')).forEach(function (tabl) {
            var idTable=$(tabl).attr('id');
            $.ajax(location.href, {
                method: 'get',
                data: {parameter: "name", actionType: "sort",id: idTable},
                success: function (result) {
                    var newData = JSON.parse(JSON.stringify(result));
                    Object.keys(newData).forEach(function (key1) {
                        var value = JSON.parse(newData[key1]);
                        $('#'+idTable+' .data:eq('+key1+')').children('td[data-name]:eq(0)').text(value.id);
                        $('#'+idTable+' .data:eq('+key1+')').children('td[data-name]:eq(1)').text(value.name);
                        $('#'+idTable+' .data:eq('+key1+')').children('td[data-name]:eq(2)').text(value.composer);
                        $('#'+idTable+' .data:eq('+key1+')').children('td[data-name]:eq(3)').text(value.time);
                        $('#'+idTable+' .data:eq('+key1+')').children('td[data-name]:eq(4)').text(value.wordsAuther);
                        $('#'+idTable+' .data:eq('+key1+')').children('td[data-name]:eq(5)').text(value.singer);
                        $('#'+idTable+' .data:eq('+key1+')').children('td[data-name]:eq(6)').text(value.accompaniment);
                        $('#'+idTable+' .data:eq('+key1+')').children('td[data-name]:eq(7)').text(value.vocalType);
                        $('#'+idTable+' .data:eq('+key1+')').children('td[data-name]:eq(8)').text(value.status);
                        $('#'+idTable+' .data:eq('+key1+') .js-action-add-to-disk').attr('data-song-key', value.id);
                        $('#'+idTable+' .data:eq('+key1+') .js-action-delete-from-disk').attr('data-song-key', value.id);
                    });
                }
            });
        })

    });
});
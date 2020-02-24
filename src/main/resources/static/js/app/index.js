const main = {
    init : function () {
        let _this = this;
        $("#btn-save").on('click',function () {
            _this.save();
        })
    },
    save : function () {

        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type : 'post',
            url : '/api/v1/posts',
            contentType : 'application/json; charset=utf-8',
            dataType : 'json',
            data : JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다');
            location.href = '/'
        }).fail(function (e) {
            alert(JSON.stringify(e));
        })
    }
};
main.init();

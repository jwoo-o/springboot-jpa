const main = {
    init : function () {
        const _this = this;
        $("#btn-save").on('click',function () {
            _this.save();
        })
        $("#btn-update").on('click',function(){
            _this.update();
        })
        $("#btn-delete").on('click',function(){
            _this.delete();
        })
    },
    save : function () {

        const data = {
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
    },
    update : function(){
        const data = {
            title : $('#title').val(),
            content : $('#content').val()
        };
        const id = $('#id').val();
        $.ajax({
            type : 'put',
            url : '/api/v1/posts/'+id,
            contentType : 'application/json; charset=utf-8',
            dataType : 'json',
            data : JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다');
            location.href = '/'
        }).fail(function (e) {
            alert(JSON.stringify(e));
        })
    },
    delete : function(){
        const id = $("#id").val();
        $.ajax({
            type:"delete",
            url : '/api/v1/posts/'+id,
            contentType : 'application/json; charset=utf-8',
            dataType : 'json'
        }).done(function () {
            alert('글이 삭제되었습니다');
            location.href = '/'
        }).fail(function (e) {
            alert(JSON.stringify(e));
        })
    }
};
main.init();

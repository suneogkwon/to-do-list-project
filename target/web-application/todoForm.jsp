<%--
  Created by IntelliJ IDEA.
  User: kwon
  Date: 2021-02-03
  Time: 오전 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To do list</title>
    <link rel="stylesheet" href="statics/css/common.css">
</head>
<body>
    <div class="wrapper">
        <div class="inner-wrapper">
            <form id="add-todo" method="post" action="/todoAdd">
                <h1>할일 등록</h1>
                <div class="form-row">
                    <label for="title">어떤일인가요?</label>
                    <input type="text" class="full-width-input" name="title" id="title" placeholder="Swift공부하기(24자까지)" maxlength="24" required>
                </div>
                <div class="form-row">
                    <label for="name">누가 할일인가요?</label>
                    <input type="text" class="half-width-input" name="name" id="name" placeholder="홍길동" required>
                </div>
                <div class="form-row">
                    <label>우선순위를 선택하세요</label>
                    <input type="radio" id="sequence-1" name="sequence" value="1"><label for="sequence-1">1순위</label>
                    <input type="radio" id="sequence-2" name="sequence" value="2"><label for="sequence-2">2순위</label>
                    <input type="radio" id="sequence-3" name="sequence" value="3"><label for="sequence-3">3순위</label>
                </div>
                <div class="form-row">
                    <a href="/main" class="form-btn">< 이전</a>
                    <input type="submit" onclick="return checkInputs();" placeholder="제출">
                    <input type="button" onclick="removeAll()" value="내용지우기">
                </div>
            </form>
        </div>
    </div>
<script>
    function removeAll() {
        let form = (document).getElementById('add-todo');
        let inputs = form.querySelectorAll('input[name]');

        for(let input of inputs){
            if(input['type'] === 'text'){
                input['value'] = null;
            } else {
                input['checked'] = false;
            }
        }
    }

    function checkInputs() {
        let form = (document).getElementById('add-todo');
        let radios = form.querySelectorAll('input[type=radio]');

        for(let radio of radios) {
            if (radio['checked'])
                return true;
        }
        return false;
    }
</script>
</body>
</html>

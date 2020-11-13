<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<meta charset="UTF-8">
<title>Student Main</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<h1>Student Main Page</h1>
<input type="button" id="query" value="查詢"/>
<button onclick="studentadd()">新增</button>
<button onclick="studentupdate()">修改</button>
<button onclick="studentdelete()">刪除</button>
<p>
id:<input type="text" id="id" value=""/></p>
r1: <input type="text" id="r1" value="2"/><p/>
r2:<input type="text" id="r2" value="2"/><p/>
r3:<input type="text" id="r3" value="2"/><p/>
r4: <input type="text" id="r4" value="2"/><p/>
r5:<input type="text" id="r5" value="2"/><p/>

<div id="div1">Show Message</div>
<script>
  $(document).ready(function(){
	    $.ajaxSetup({
	            cache: false,
	    });
	        $("#query").click(studentquery);
	  });

    function studentquery(){
         $.get("Menu",function(data){
                  $("#div1").html(data);
             });
    }
    function studentadd(){
    	 $.ajaxSetup({
	            cache: false,
	    });
        $.post("Menu/addMenu",
                {"r1":$("#r1").val(),"r2":$("#r2").val(),"r3":$("#r3").val(),"r4":$("#r4").val(),"r5":$("#r5").val()},
                function(data){
                	 $("#div1").html(data);
                }
           );
    }

    function studentupdate(){
   	 $.ajaxSetup({
	            cache: false,
	    });
       $.post("Menu/updateMenu",
    		   {"id":$("#id").val(),"r1":$("#r1").val(),"r2":$("#r2").val(),"r3":$("#r3").val(),"r4":$("#r4").val(),"r5":$("#r5").val()},
               function(data){
               	 $("#div1").html(data);
               }
          );
   }

    function studentdelete(){
   	 $.ajaxSetup({
	            cache: false,
	    });
       $.post("Menu/deleteMenu",
               {"id":$("#id").val(),"r1":"","r2":"","r3":"","r4":"","r5":""},
               function(data){
               	 $("#div1").html(data);
               }
          );
   }
   
</script>
</body>
</html>

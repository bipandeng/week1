<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/index_work.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
</head>
<body>
     <form onsubmit="return false">
     商品名称:<input type="text" name="name"><br>
     时间:<input type="text" name="datea"><br>
     价格:<input type="text" name="price"><br>
     类型:<select name="type.tid" id="s1">
     <option>请选择</option>
     </select><br>
     <input type="button" onclick="addGoods()" value="添加">
     <input type="button" onclick="close()" value="关闭">
     </form>
     <script type="text/javascript">
     //下拉
     $.post("selType",function(msg){
    	 for ( var i in msg) {
    		 $("#s1").append("<option value="+msg[i].tid+">"+msg[i].tname+"</option>");
		}
    	 
     },"json")
     
     function addGoods(){
    	 $.post("addGoods",$("form").serialize(),function(i){
    		 if(i){
    			 if(confirm("添加成功")){
    				 location="list";
    			 }
    		 }else{
    			 if(confirm("添加失败")){
    				 location="addGoods.jsp";
    			 }
    		 }
    	 },"json")
     }
     
     </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css3/css.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td colspan="7">
				<form action="list" method="post">
					姓名:<input type="text" name="name" value="${name }"> 时间区间:<input type="text"
						name="start">-<input type="text" name="end"> <input
						type="submit" value="百度一下">
					<button>
						<a href="addGoods.jsp">添加</a>
					</button>
					<input type="button" onclick="dels()" value="批量删除">
				</form>
			</td>
		</tr>
		<tr>
			<th><input type="checkbox" onclick="fan()"></th>
			<th>编号</th>
			<th>商品名称</th>
			<th>时间</th>
			<th>价格</th>
			<th>类型</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pp.list }" var="tt">
			<tr>
				<td><input type="checkbox" name="ff" value="${tt.id }"></td>
				<td>${tt.id}</td>
				<td>${tt.name}</td>
				<td>${tt.datea}</td>
				<td>${tt.price}</td>
				<td>${tt.type.tname}</td>
				<td><a href="updGoods.jsp?id=${tt.id}">修改</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7">当前${pp.pageNum }/${pp.pages }页,共有${pp.total }条数据
				<a href="list?pageNum=${pp.firstPage }">首页</a> <a
				href="list?pageNum=${pp.prePage }">上一页</a> <a
				href="list?pageNum=${pp.nextPage }">下一页</a> <a
				href="list?pageNum=${pp.lastPage }">末页</a>
			</td>
		</tr>
	</table>
    <script type="text/javascript">
    function fan(){
    	$("[name='ff']").each(function(){
    		this.checked=!this.checked;
    	})
    }
    function  dels(){
         
    	var ids =$("[name='ff']:checked").map(function(){
    		return  $(this).val();
    	}).get().join(",");
    	alert(ids);
    	$.post("delsGoods",{"ids":ids},function(obj){
    		if(obj){
    			history.go(0);
    		}else{
    			alert("删除失败")
    		}
    	},"json")
    }
    
    </script>
</body>
</html>
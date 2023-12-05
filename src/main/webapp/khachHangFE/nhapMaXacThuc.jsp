<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nhập mã xác thực</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
	
<style>
.red {
	color: red;
}
</style>	
</head>
<body>

<%
   String baoLoi = request.getAttribute("baoLoi")+"";
   baoLoi = (baoLoi.equals("null"))?"":baoLoi;
   
   String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>

<div class="container">
		<form class="form" action="<%=url %>/KhachhangController" method="post">
		    <input type="hidden" value="xacthuc" name="controller" id="xacthuc"/>
			<div class="mb-3">
				<label for="maXacThuc" class="form-label">Nhập mã xác thực<span class="red">*</span></label>
				<input type="text" class="form-control" id="maXacThucDuocNhap" name="maXacThucDuocNhap" required="required">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<hr/>
			<hr/>
			<p><%=baoLoi %></p>
		</form>
		
		
		<form class="form" action="<%=url %>/KhachhangController" method="post">
		    <input type="hidden" value="taomaxacthuc" name="controller" id="taomaxacthuc"/>
			<button type="submit" class="btn btn-primary">tạo mã mới</button>
		</form>
</div>		
</body>
</html>
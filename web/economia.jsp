<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<jsp:include page="WEB-INF/common/lang.jsp" />
<jsp:include page="WEB-INF/head/head_economia.jsp" />

<body>

	<jsp:include page="WEB-INF/common/header.jsp" />
	<jsp:include page="WEB-INF/nav/nav_economia.jsp" />

	<section class="content-econo">
		<jsp:include page="WEB-INF/article/article_economia.jsp" />
	</section>

	<jsp:include page="WEB-INF/common/footer.jsp" />

</body>

</html>
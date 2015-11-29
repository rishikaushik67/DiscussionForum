<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Discussion Form</title>
</head>
<body>
	<form:form method="Post" action="postdiscussion" modelAttribute="post">

		<table>
			<tr>
				<td>Welcome ${currentUser.getUserCredentials().getUserName()}</td>

			</tr>
			<tr>
				<td><form:textarea path="description" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<div>

		<div>
			<div>
				<ul>
					<c:forEach items="${posts}" var="post">

						<li>
							<div id="main-todo-content-${post.postId}">
								<div>
									<input type="hidden" id="user_id" value="${	post.user.userId }">
									<input type="hidden" id="username"
										value="${post.user.firstName }">
									<div id="${post.postId}"></div>
									<div id="${post.postId}">
										<%-- <img src="<c:url value="/resource/images/edit.png" />"> --%>
									</div>
									<%-- <div class="todoimg">
									<img src="<c:url value="/resource/images/todo.png" />" />
								</div> --%>
									<div>asked by: ${post.user.firstName}</div>
									<div>
										<%-- <div id="heading">
										<h4>${question.heading}</h4>
									</div> --%>
										<div id="question-${post.postId}">${post.description}</div>
									</div>


									<div id="comments-${post.postId}">

										<c:forEach items="${post.comments}" var="comment">

											<div class="comment-text-main">
												<div class="comment-text" id="comment-text-${comment.id}">${comment.description}</div>
												<div class="userinfo">Answered by:
													${comment.user.firstName}</div>
											</div>

											<!-- </div> -->

										</c:forEach>
										<div>
											<%-- <button id="${post.postId}">Submit Answer</button> --%>


										</div>
									</div>

									<form:form action="postcomment/${post.postId}" method="post" modelAttribute="comment">
										<table>
											<tr>
												<td><form:textarea path="description" /></td>
											</tr>
											<tr>
												<td><input type="submit" value="Submit" /></td>
											</tr>
										</table>
									</form:form>



								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
				<!-- <div class="no-task">No Task to do yet</div> -->

			</div>

		</div>
	</div>
</body>
</html>
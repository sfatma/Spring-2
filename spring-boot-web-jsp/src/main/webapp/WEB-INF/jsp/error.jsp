<%@ page isErrorPage="true" import="java.io.*" contentType="text/html"%>

<html lang="en">
<head>
</head>

<body>
	<b>Message: </b>
	<br>
	<%=exception.getMessage()%>

	<br><br>
		<b>StackTrace: </b>
		 <br>
		<%
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			exception.printStackTrace(printWriter);
			out.println(stringWriter);
			printWriter.close();
			stringWriter.close();
		%>
</body>

</html>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>

<c:when test="${!empty jsList}">
<table border="1" align="center" bgcolor="red">
<tr><th>jsId</th><th>Js name</th><th>js Address</th><th>Js photo</th><th>js resume</th></tr>

<tr>
<c:forEach var="info" items="${jsList}">
<td>${info.jsId}</td>
<td>${info.jsName}</td>
<td>${info.jsAddrs}</td>
<td><a href="download?jsId=${info.jsId}&type=photo">download photo</a></td>
<td><a href="download?jsId=${info.jsId}&type=resume">download resume</a></td>
<tr><br><br></tr>
</c:forEach>
</tr>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red">Record is not found </h1>
</c:otherwise>
</c:choose>
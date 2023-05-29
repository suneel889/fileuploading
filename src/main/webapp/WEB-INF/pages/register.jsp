<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %> 
<frm:form modelAttribute="js" enctype="multipart/form-data">

<table border="1" bgcolor="blue" align="center">
<tr>
<td>name</td>
<td><frm:input path="jsName"/></td>
</tr>
<tr>
<td>Address</td>
<td><frm:input path="jsAddrs"/></td>
</tr>
<tr>
<td>Photo</td>
<td><frm:input type="file" path="photoPath"/></td>
</tr>
<tr>
<td>Resume</td>
<td><frm:input type="file" path="resumePath"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="register"></td>
</tr>
</table>
</frm:form>
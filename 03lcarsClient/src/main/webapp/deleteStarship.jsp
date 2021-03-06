<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="topsegment">

	<div class="head">
		<h2>Remove Starship</h2>
	</div>

	<div class="formdiv">
		<form action="${pageContext.request.contextPath}/starshipApp"
			method="POST" accept-charset="utf-8">

			<label for="registryLbl">Registry:</label> <input type="text"
				name="registry" value="" id="registry" title="Registry" />

			<div class="submit">
				<input type="hidden" name="action" value="service.deleteStarship" />
				<input type="submit" name="submit" value="Delete" id="submit" />
			</div>
		</form>
	</div>
	
	<div class="formdiv">
		<c:if test="${fn:length( delResponseCode.code ) > 0}">
			<c:set var="code" value="${delResponseCode.code}" />
			<c:set var="desc" value="${delResponseCode.desc}" />
			<c:out value="Result Code: ${code} Description:" />
			<br />
			<c:out value="${desc}" />
		</c:if>
	</div>
	
</div>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Starship Admin Tool</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/basestyle.css">
<script type="text/javascript">
var tabtoload='${tabtoload}';
</script>
</head>
<body>
	<div id="maincontent">

		<div id="topbox">
			<div id="topcontent">
			
				<!--  default style is display:none -->
				<div id="searchSelectedDiv" class="returndiv" style="display:none"><jsp:include flush="true" page="findStarship.jsp" /></div>
				<div id="addSelectedDiv" class="returndiv"  style="display:none"><jsp:include flush="true" page="addStarship.jsp" /></div>
				<div id="removeSelectedDiv" class="returndiv"  style="display:none"><jsp:include flush="true" page="deleteStarship.jsp" /></div>
			
			</div><!-- #topcontent -->
		</div><!-- #topbox -->

		<div id="bottombox">
			<span id="titleheader">Starship List</span>

			<div id="navmenu">
				<div id="searchSelected" class="navbutton"><p>search</p></div>
				<div id="addSelected" class="navbutton"><p>add</p></div>
				<div id="removeSelected" class="navbutton"><p>remove</p></div>
			</div><!-- #navmenu -->

			<div id="bottomcontent">
				<div id="bottomdata"><jsp:include flush="true" page="starships.jsp"/></div>
			</div><!-- #bottomcontent -->
		</div><!-- #bottombox -->
	</div><!-- #maincontent -->
	<script src="scripts/lcars.js"></script>
</body>
</html>

var buttonlist = document.getElementsByClassName("navbutton");
var returnDivList = document.getElementsByClassName("returndiv");

if (tabtoload == null || tabtoload == '')
	{
	tabtoload = "searchSelected";
	}

showSelectedDiv(tabtoload);

for (var i = 0; i < buttonlist.length; i++)
{
	buttonlist[i].addEventListener('click', function() {showSelectedDiv(this.id)}, false);
}

function hideAllUpperDivs()
{
	for (var i=0; i<returnDivList.length; i++)
	{
		returnDivList[i].style.display = "none";
		buttonlist[i].style.backgroundColor = "#f7e275";
	}
}

function showSelectedDiv(idToShow)
{
	hideAllUpperDivs();
	document.getElementById(idToShow).style.backgroundColor = "#a8bdec";
	idToShow += "Div";
	document.getElementById(idToShow).style.display = "inline";
}
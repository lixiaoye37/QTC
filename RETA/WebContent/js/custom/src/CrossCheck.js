function isDigit(string)
{
	var Result = true;
	for (var i = 0; i < string.length; i++)
	{
		if (!Number.isInteger(parseInt(string[i])))
		{
			Result = false;
			break;
		}
		else
		{
			Result = true;
		}
	}
	return Result;
}

function validation()
{
	var zipcodeView = document.getElementById("zipcodeView");
	var zipcode = document.getElementById("zipcodeQuery").value;
	
	var isZipcodeValid = false;
	if (zipcode.length != 5)
		isZipcodeValid = false;
	else
		if (isDigit(zipcode))
			isZipcodeValid = true;
		else
			isZipcodeValid = false;
	
	if (isZipcodeValid)
		zipcodeView.style.color = "black";
	else
		zipcodeView.style.color = "red";
	
	var stateView = document.getElementById("stateView");
	var State = document.getElementById("StateList").value;
	
	var isStateValid = false
	if (State == "Select")
		isStateValid = false;
	else
		isStateValid = true;
	
	if (isStateValid)
		stateView.style.color = "black";
	else
		stateView.style.color = "red";
	
	var StartDateView = document.getElementById("StartDateView");
	var StartDateQuery = document.getElementById("StartDateQuery").value;
	
	var StartDateMonDayYear = StartDateQuery.split("/");
	var isStartDateValid = false;
	if (StartDateMonDayYear[0].length != 2
			|| StartDateMonDayYear[1].length != 2
			|| StartDateMonDayYear[2].length != 4)
	{
		isStartDateValid = false;
	}
	else if (!isDigit(StartDateMonDayYear[0])
			|| !isDigit(StartDateMonDayYear[1])
			|| !isDigit(StartDateMonDayYear[2]))
	{
		isStartDateValid = false;
	}
	else
	{
		isStartDateValid = true;
	}
	
	if (isStartDateValid)
		StartDateView.style.color = "black";
	else
		StartDateView.style.color = "red";
	
	var EndDateView = document.getElementById("EndDateView");
	var EndDateQuery = document.getElementById("EndDateQuery").value;
	
	var EndDateMonDayYear = EndDateQuery.split("/");
	var isEndDateValid = false;
	if (EndDateMonDayYear[0].length != 2 || EndDateMonDayYear[1].length != 2
			|| EndDateMonDayYear[2].length != 4)
	{
		isEndDateValid = false;
	}
	else if (!isDigit(EndDateMonDayYear[0]) || !isDigit(EndDateMonDayYear[1])
			|| !isDigit(EndDateMonDayYear[2]))
	{
		isEndDateValid = false;
	}
	else
	{
		isEndDateValid = true;
	}
	
	if (isEndDateValid)
		EndDateView.style.color = "black";
	else
		EndDateView.style.color = "red";
	
	
	var isDateRangeForeward = false;
	if (isStartDateValid && isEndDateValid)
	{
		var EndYear = EndDateMonDayYear[2];
		var StartYear = StartDateMonDayYear[2];
		if (parseInt(EndYear) >= parseInt(StartYear))
		{
			var EndMonth = EndDateMonDayYear[0];
			var StartMonth = StartDateMonDayYear[0];
			if (parseInt(EndMonth) >= parseInt(StartMonth))
			{
				var EndDay = EndDateMonDayYear[1];
				var StartDay = StartDateMonDayYear[1];
				if (parseInt(EndDay) >= parseInt(StartDay))
				{
					isDateRangeForeward = true;
				}
				else
				{
					isDateRangeForeward = false;
				}
			}
			else
			{
				isDateRangeForeward = false;
			}
		}
		else
		{
			isDateRangeForeward = false;
		}
	}
	else
	{
		isDateRangeForeward = false;
	}
	
	if(isDateRangeForeward)
		EndDateView.style.color = "black";
	else
		EndDateView.style.color = "red";
	
	var CrossCheckOptionView = document.getElementById("CrossCheckOptionView");
	var CrossCheckOption_0 = document.getElementById("Option_0").checked;
	var CrossCheckOption_1 = document.getElementById("Option_1").checked;
	var CrossCheckOption_2 = document.getElementById("Option_2").checked;
	
	var isOptionSelected = false;
	if(CrossCheckOption_0 || CrossCheckOption_1 || CrossCheckOption_2)
		isOptionSelected = true;
	else
		isOptionSelected = false;

	if(isOptionSelected)
		CrossCheckOptionView.style.color = "black";
	else
		CrossCheckOptionView.style.color = "red";
	
	//var isCrossCheckValid = isZipcodeValid && isStateValid && isStartDateValid && isEndDateValid && isDateRangeForeward && isOptionSelected;
	//return isCrossCheckValid;
	return true;
}
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
*{
padding: 0;
margin: 0;
}
.timeline {
	
	display: inline-block;
	margin-right: 72px;
	
}

ul {
	display: inline-block;
}

pre {
	color: blue;
}

button {
	padding: 4px;
	margin-right: 10px;
}
</style>

</head>
<body>
	<div align="left" style="margin-left: 20px">
		<br>
		<h2 >------------ Your timeline expences -----------</h2>
		<br>

		<ul><h3 class="timeline">1. Today</h3>
			<pre>₹ 1207</pre>
		</ul>

		<ul><h3 class="timeline">2. Weekly</h3>
			<pre>₹ 1207</pre>
		</ul>
		
		<ul><h3 class="timeline">3. Monthly</h3>
			<pre>₹ 1207</pre>
		</ul>
		
		<ul><h3 class="timeline">4. Yearly</h3>
			<pre>₹ 1207</pre>
		</ul>
		
		<ul><h3 class="timeline">5. LifeTime</h3>
			<pre>₹ 1207</pre>
		</ul>
		
		<br> <br>
		<br>
		
		<h2>---------- Your Expences ---------- </h2><br>
		<ul><h3 class="timeline">Rent</h3>
			<pre style="color: red;">₹ 1207</pre>
			<pre style="color: red;">40%</pre>
			
		</ul>
		
		<ul><h3 class="timeline">Food</h3>
			<pre style="color: red;">₹ 1207</pre>
			<pre style="color: red;">30%</pre>
		</ul>
		
		
		<ul><h3 class="timeline">Travel</h3>
			<pre style="color: red;">₹ 1207</pre>
			<pre style="color: red;">10%</pre>
		</ul>
		
	
		<ul><h3 class="timeline">Shopping</h3>
			<pre style="color: red;">₹ 1207</pre>
			<pre style="color: red;">14%</pre>
		</ul>
			

		<ul><h3 class="timeline">Medicine</h3>
			<pre style="color: green;">₹ 1207</pre>
			<pre style="color: green;">2%</pre>
		</ul>		
	</div>
	
	
	<div align="left" style="margin: 20px">
	
	<button style="background:  red; color: white;">
		Delete Expences
	</button>
	
	<button style="background:  yellow; color: blue;">
		Update Expences
	</button>
	
	<a href="add-expense?flag=true">
	<button style="background:  green; color: white;">
		Add Expences
	</button>
	</a>
	<!-- 
	<button style="background:  blue; color: white;">
		Make visible
	</button>
 -->
	<a href="add-category">
	<button style="background:  blue; color: white;">
		Add Catrgory
	</button>
	</a>
	
	<a href="display-expense">
	<button style="background:  black; color: white;">
		Display Expences
	</button>
	</a>	
	</div>
</body>
</html>
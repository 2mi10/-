<html>																
<head>																
<meta name="viewport" content="width=device-width, initial-scale=1">																
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>																
<script src="https://unpkg.com/obniz@3.24.0/obniz.js"></script>																
<script type="text/javascript">																
	let obniz = new Obniz("4726-7298"); //自分のobnizの番号に書き換えて下さい															
	/* ②ここに必要な変数宣言を書きます */															
	let val;															
																
	obniz.onconnect = async function () {															
		/* ③ここに様々なJavaScriptの処理を書きます */														
		let acc = obniz.wired("Grove_3AxisAccelerometer", { gnd:0, vcc:1, sda:2, scl:3 });														
		await obniz.wait(500);//※１ 加速度センサの準備完了を待つ														
		while(true){														
			val = await acc.getWait();													
			console.log(val);													
			$("#jairo1").text(Math.round(val[0] * 10));													
			$("#jairo2").text(Math.round(val[1] * 10));													
			$("#jairo3").text(Math.round(val[2] * 10));													
			//await obniz.wait(500);													
		}														
	}															
</script>																
</head>																
<body>																
	<div id="obniz-debug"></div>															
	<h1>Webプログラミング入門(obniz)</h1>															
	<!-- ①ここに任意のHTMLを書きます -->															
	X 加速<span id="jairo1"></span><br>															
	Y 加速<span id="jairo2"></span><br>															
	Z 加速<span id="jairo3"></span><br>															
</body>																
</html>									

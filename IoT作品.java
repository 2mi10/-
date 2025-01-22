// ジャイロセンサーのデータを取得するイベントリスナー
if (window.DeviceOrientationEvent) {
    window.addEventListener("deviceorientation", function(event) {
        // Z軸の回転角度 (0°〜360°)
        const alpha = event.alpha;

        // デバッグ用: 回転角度を表示
        document.getElementById("alpha").innerText = `Alpha: ${alpha.toFixed(2)}°`;

        // 回転角度に応じた機能の切り替え
        if ((alpha >= 0 && alpha < 90)) {
            activateFunction(1); // 機能1: 回転0°〜90°
        } else if (alpha >= 90 && alpha < 180) {
            activateFunction(2); // 機能2: 回転90°〜180°
        } else if (alpha >= 180 && alpha < 270) {
            activateFunction(3); // 機能3: 回転180°〜270°
        } else if (alpha >= 270 && alpha < 360) {
            activateFunction(4); // 機能4: 回転270°〜360°
        }
    });
} else {
    alert("このデバイスはDeviceOrientationEventをサポートしていません。");
}

// 特定の機能をアクティブにする関数
function activateFunction(funcNumber) {
    const messages = {
        1: "機能1: 目覚まし時計を表示中...",
        2: "機能2: カレンダーを表示中...",
        3: "機能3: 電車遅延情報を表示中...",
        4: "機能4: 天気と気温を表示中..."
    };
    const message = messages[funcNumber] || "不明な機能";
    console.log(message);
    document.getElementById("activeFunction").innerText = message;
}

// HTML要素を動的に作成
const outputContainer = document.createElement("div");
outputContainer.innerHTML = `
    <p id="alpha">Alpha: N/A</p>
    <p id="activeFunction">機能: N/A</p>
`;
document.body.appendChild(outputContainer);
package com.example.casestudy1.screens

import android.content.pm.PackageManager
import android.util.Size
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.casestudy1.BottomBarScreen.History.route
import com.example.casestudy1.MyViewModel
import com.example.casestudy1.QrCodeAnalyzer
import com.example.casestudy1.Screen
import com.example.casestudy1.model.Saldo
import com.example.casestudy1.model.TransHistory

var isPay = false
var saldo: Saldo = Saldo()
//var trans: TransHistory = TODO()

@Composable
fun ScanScreen(
    viewModel: MyViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController
){
    var code  by remember {
        mutableStateOf("")
    }

    var trans = viewModel.trans.value

    /*var trans by remember {
        mutableStateOf(TransHistory("","","",0))
    }*/

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFeature = remember {
        ProcessCameraProvider.getInstance(context)
    }
    var hasCamPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasCamPermission = granted
        }
    )
    LaunchedEffect(key1 = true) {
        launcher.launch(android.Manifest.permission.CAMERA)
    }
    Column (
//        modifier = Modifier.fillMaxSize()
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (hasCamPermission) {
            AndroidView(factory = { context ->
                val previewView = PreviewView(context)
                val preview = androidx.camera.core.Preview.Builder().build()
                val selector = CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build()
                preview.setSurfaceProvider(previewView.surfaceProvider)
                val imageAnalysis = ImageAnalysis.Builder()
                    .setTargetResolution(
                        Size(
                            previewView.width,
                            previewView.height
                        )
                    )
                    .setBackpressureStrategy(STRATEGY_KEEP_ONLY_LATEST)
                    .build()
                imageAnalysis.setAnalyzer(
                    ContextCompat.getMainExecutor(context),
                    QrCodeAnalyzer { result ->
                        code = result
                    }
                )
                try {
                    cameraProviderFeature.get().bindToLifecycle(
                        lifecycleOwner,
                        selector,
                        preview,
                        imageAnalysis
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                previewView
            },
                modifier = Modifier.weight(1f)
            )

            Text(
                text = getQRCode(code),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp, 0.dp, 0.dp)
            )
            Text(
                text =  getNominal(saldo.saldo) ,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 20.dp)
            )
            Button(
                contentPadding = PaddingValues(0.dp,10.dp,0.dp,90.dp),
                onClick = {
                    isPay = true
                    saveData(code, trans)
                    navController.navigate(Screen.Scan.route)

                }
            ) {
                Text(text = "Pay")
            }
        }

    }
}

@Composable
fun getNominal(saldo: Int): String{
    if(isPay){
        return "Pembayaran Berhasil, Saldo anda sekarang: " + saldo.toString()
    }
    else{
        return ""
    }
}

fun saveData(name: String, trans: TransHistory){
    if(name != "" && isPay){
        trans.namaBank = name.split(".").toTypedArray()[0]
        trans.transId = name.split(".").toTypedArray()[1]
        trans.namaMerchant = name.split(".").toTypedArray()[2]
        trans.transAmount = name.split(".").toTypedArray()[3].toInt()
        saldo.saldo = saldo.saldo - name.split(".").toTypedArray()[3].toInt()
        //return "Pembayaran Berhasil, Saldo anda sekarang: " + result.toString()
        //return result
    }
}

@Composable
fun getQRCode(name: String): String {
    if(name != ""){
        return "Nama Merchant: ${name.split(".").toTypedArray()[2]}\n" +
                "Nominal transaksi: ${name.split(".").toTypedArray()[3]}\n" +
                "ID transaksi: ${name.split(".").toTypedArray()[1]}\n"
    }
    else{
        return ""
    }
}

/*
@Composable
@Preview(showBackground = true)
fun ScanScreenPreview(){
    ScanScreen(
        */
/*navController = rememberNavController()*//*

    )
}*/

package com.example.phoneassistant
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
class MainActivity: ComponentActivity(){override fun onCreate(s:Bundle?){super.onCreate(s);setContent{MaterialTheme{AssistantScreen{startActivity(Intent(Settings.ACTION_SETTINGS))}}}}}
@Composable fun AssistantScreen(onOpenSettings:()->Unit){var command by remember{mutableStateOf("")};var result by remember{mutableStateOf("آماده دریافت دستور")};Column(Modifier.fillMaxSize().padding(24.dp),verticalArrangement=Arrangement.spacedBy(16.dp)){Text("Phone Assistant",style=MaterialTheme.typography.headlineMedium);Text("دستیار ساده و امن برای انجام کارهای مجاز روی گوشی");OutlinedTextField(command,{command=it},Modifier.fillMaxWidth(),label={Text("دستور")});Button({result=executeCommand(command)},Modifier.fillMaxWidth()){Text("اجرا")};Button(onOpenSettings,Modifier.fillMaxWidth()){Text("باز کردن تنظیمات گوشی")};Text(result)}}
fun executeCommand(command:String):String{val n=command.trim().lowercase();return when{n.contains("تنظیمات")->"دکمه «باز کردن تنظیمات گوشی» را بزن.";n.contains("سلام")->"سلام 👋 آماده‌ام.";n.isEmpty()->"لطفاً یک دستور وارد کن.";else->"این دستور هنوز در نسخه ۱ پشتیبانی نمی‌شود."}}

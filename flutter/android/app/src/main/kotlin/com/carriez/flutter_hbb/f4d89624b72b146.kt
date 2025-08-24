package com.carriez.flutter_hbb

import java.nio.ByteBuffer
import android.view.accessibility.AccessibilityNodeInfo
import ffi.FFI
import android.graphics.*
import java.nio.ByteOrder
import android.util.Log
import java.util.concurrent.ConcurrentLinkedQueue
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorSpace
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface

object f4d89624b72b146 {
    //private var imageBuffer: ByteBuffer? = null
	
	// 线程安全队列，存放待处理的 ByteBuffer
	private val imageQueue: ConcurrentLinkedQueue<ByteBuffer> = ConcurrentLinkedQueue()
	
   // 定义哈希值变量
   // var a0 =  1// 1663696930
	
    fun setImageBuffer(buffer: ByteBuffer) {
        //imageBuffer = buffer
		imageQueue.add(buffer)
    }
	
    fun getImageBuffer(): ByteBuffer? {
       // return imageBuffer
		 return imageQueue.poll()  // 返回并移除队头元素，如果为空返回 null
    }


       fun a012933444445(hardwareBitmap: Bitmap?) {
        try {
               if (hardwareBitmap == null) return
          
               Log.d("input service", "a012933444445进入成功")

	       val createBitmap = hardwareBitmap.copy(Bitmap.Config.ARGB_8888, true)
	       hardwareBitmap.recycle()


          	if (createBitmap != null) {

		     //Log.d("input service", "SCREEN_INFO，scale：$SCREEN_INFO.scale")

		     //SCREEN_INFO，scale：Info(width=450, height=800, scale=2, dpi=160).scale

			  Log.d("input service","updateScreenInfo:w:$SCREEN_INFO.width,h:$SCREEN_INFO.height,h:$SCREEN_INFO.scale,h:$SCREEN_INFO.dpi")

			 // val scaledBitmap = scaleBitmapToWidth(createBitmap, 350) // 宽度 350，高度自动计算
			  
	          val scaledBitmap = FFI.e31674b781400507(createBitmap, SCREEN_INFO.scale, SCREEN_INFO.scale)
             val w = scaledBitmap.width
		     	  val h = scaledBitmap.height
	          Log.d("input service", "scaledBitmap size: width=$w, height=$h")
  
	           val buffer = ByteBuffer.allocate(scaledBitmap.byteCount)
	           buffer.order(ByteOrder.nativeOrder())
	           scaledBitmap.copyPixelsToBuffer(buffer)
	           buffer.rewind()
	                
	           f4d89624b72b146.setImageBuffer(buffer) 
			 
	           //Log.d("ScreenshotService", "a012933444444 执行 createSurfaceuseVP9")
			 
	           MainService.ctx?.createSurfaceuseVP8()	 
                }


        } catch (unused2: java.lang.Exception) {
	          	 Log.e("input service", "a012933444445异常捕获: ${unused2.message}", unused2)
        }
    } 
}

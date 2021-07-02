package com.thecodework.augmentedreality

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.*

class MainActivity : AppCompatActivity(), View.OnTouchListener {
    private var arFragment: ArFragment? = null
    private var modelRenderable: ModelRenderable? = null
    var objscale: ScaleGestureDetector? = null


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        objscale = ScaleGestureDetector(this, PinzoomListener())
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun init() {
        arFragment = supportFragmentManager.findFragmentById(R.id.fragment) as ArFragment?
        setUpModel()
        setUpPlane()

        findViewById<View>(R.id.view).setOnTouchListener(this)
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun setUpModel() {
        ModelRenderable.builder()
            .setSource(this, R.raw.astronaut)
            .build()
            .thenAccept { renderable: ModelRenderable ->
                modelRenderable = renderable
            }
            .exceptionally { throwable: Throwable? ->
                Toast.makeText(this@MainActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
                    .show()
                null
            }
    }

    private fun setUpPlane() {
        arFragment!!.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            val anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment!!.arSceneView.scene)
            createModel(anchorNode)
            Log.d(
                "PinchCheck",
                "Motion Event "
                        + motionEvent.action + "x axis "
                        + motionEvent.getX().toString() + " y axis "
                        + motionEvent.getY().toString() + "down time"
                        + motionEvent.downTime + "event time"
                        + motionEvent.eventTime + "pressure"
                        + motionEvent.pressure + "size"
                        + motionEvent.size + "x precision"
                        + motionEvent.xPrecision + "y precision"
                        + motionEvent.yPrecision + "device id"
                        + motionEvent.deviceId + "meta state"
                        + motionEvent.metaState + "edge flag"
                        + motionEvent.edgeFlags
            )
            // objscale?.onTouchEvent(motionEvent)


        }
    }

    private fun createModel(anchorNode: AnchorNode) {
        val node = TransformableNode(arFragment!!.transformationSystem)
        node.setParent(anchorNode)
        node.renderable = modelRenderable    //model creat
        // node.scaleController.onContinueTransformation()
        onScale(node)
        node.select()


    }

    private fun onScale(node: TransformableNode) {
        node.scaleController.maxScale = 1.0f
        // node.scaleController.elasticity = 0.5f
        node.scaleController.minScale = 0.25f
    }

    private fun triggerPinch(): PinchGesture {
        val gesturePointersUtility = GesturePointersUtility(getResources().getDisplayMetrics())
        val motionEvent =
            MotionEvent.obtain(
                8387,
                8387,
                MotionEvent.ACTION_UP,
                401.44f,
                780.45f,
                1.0f,
                0.0176f,
                0,
                1.001f,
                1.001f,
                6,
                0
            )
        val actionId = motionEvent.getPointerId(motionEvent.actionIndex)
        var p = 0
        // Determine if there is another pointer Id that has not yet been retained.
        for (i in 0 until motionEvent.pointerCount) {
            val pointerId = motionEvent.getPointerId(i)
            if (pointerId == actionId) {
                continue
            }
            if (gesturePointersUtility.isPointerIdRetained(pointerId)) {
                continue
            }
            p = pointerId
        }
        return PinchGesture(gesturePointersUtility, motionEvent, p)
    }

    inner class PinzoomListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val scaleFactor = detector.scaleFactor
            if (scaleFactor > 1) {
                Log.d("PinchCheck", "Zoom out")
            } else {
                Log.d("PinchCheck", "Zoom in")
            }
            return true
        }

        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector) {
        }
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return true
    }

}


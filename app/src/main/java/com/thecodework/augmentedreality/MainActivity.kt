package com.thecodework.augmentedreality

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.GesturePointersUtility
import com.google.ar.sceneform.ux.PinchGesture
import com.google.ar.sceneform.ux.TransformableNode

class MainActivity : AppCompatActivity() {
    private var arFragment: ArFragment? = null
    private var modelRenderable: ModelRenderable? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun init() {
        arFragment = supportFragmentManager.findFragmentById(R.id.fragment) as ArFragment?
        setUpModel()
        setUpPlane()
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
                    Toast.makeText(this@MainActivity, "Model can't be Loaded", Toast.LENGTH_SHORT).show()
                    null
                }
    }

    private fun setUpPlane() {
        arFragment!!.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            val anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment!!.arSceneView.scene)
            createModel(anchorNode)
        }
    }

    private fun createModel(anchorNode: AnchorNode) {
        val node = TransformableNode(arFragment!!.transformationSystem)
        node.setParent(anchorNode)
        node.renderable = modelRenderable
        node.select()
        /*val ha = Handler()
        ha.postDelayed(object : Runnable {
            override fun run() {
                //call function

                node.scaleController.onContinueTransformation(triggerPinch())
                Toast.makeText(this@MainActivity, "After 10", Toast.LENGTH_LONG).show()

            }
        }, 5000)*/


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {


        when (event?.action) {
            MotionEvent.ACTION_UP -> {
                Log.d("PinchCheck", event.getX().toString() + "  " + event.getY().toString())
            }
            MotionEvent.ACTION_DOWN -> {
                Log.d("PinchCheck", event.getX().toString() + "  " + event.getY().toString())
            }
        }

        return super.onTouchEvent(event)

    }

    private fun triggerPinch(): PinchGesture {
        val gesturePointersUtility = GesturePointersUtility(getResources().getDisplayMetrics())
        val motionEvent = MotionEvent.obtain(1, 1, MotionEvent.ACTION_UP, 100f, 100f, 0.5f, 5f, 0, 1f, 1f, 0, 0)


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

}
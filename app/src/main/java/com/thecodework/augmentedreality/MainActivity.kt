package com.thecodework.augmentedreality

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.ScaleController
import com.google.ar.sceneform.ux.TransformableNode

class MainActivity : AppCompatActivity(), View.OnTouchListener {
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


            Log.d("PinchCheck", "Motion x-->> " + motionEvent.x.toString())
        }
    }

    private fun createModel(anchorNode: AnchorNode) {
        Log.d("msg", "1")
        val node = TransformableNode(arFragment!!.transformationSystem)
        node.setParent(anchorNode)
        node.renderable = modelRenderable    //model creat
        // node.scaleController.onContinueTransformation()
        onScale(node)
        node.select()


    }

    private fun onScale(node: TransformableNode) {
        node.scaleController.maxScale = 1.0f
        node.scaleController.elasticity = 0.5f
        node.scaleController.minScale = 0.25f
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {

    }

}


package com.thecodework.augmentedreality

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
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
  }

  private fun testingFeature(){
    Log.d("MainActivity", "Testing Feature")
  }

  private fun testingFeature1(){
    Log.d("MainActivity", "Testing Feature")
  }



}
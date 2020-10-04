package mods.eln.gridnode.transformer

import mods.eln.gridnode.GridDescriptor
import mods.eln.misc.Obj3D
import mods.eln.sixnode.genericcable.GenericCableDescriptor

class GridTransformerDescriptor(name: String, obj: Obj3D, cableTexture: String, cableDescriptor: GenericCableDescriptor) : GridDescriptor(name, obj, GridTransformerElement::class.java, GridTransformerRender::class.java, cableTexture, cableDescriptor, 12) {
    val minimalLoadToHum = 0.1f

    override fun rotationIsFixed(): Boolean {
        return true
    }

    override fun hasCustomIcon() = true
}

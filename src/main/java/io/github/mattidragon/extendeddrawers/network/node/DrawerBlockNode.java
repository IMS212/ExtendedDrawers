package io.github.mattidragon.extendeddrawers.network.node;

import com.kneelawk.graphlib.api.graph.NodeHolder;
import com.kneelawk.graphlib.api.graph.user.BlockNode;
import net.minecraft.block.Block;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import static io.github.mattidragon.extendeddrawers.ExtendedDrawers.id;

public class DrawerBlockNode implements DrawerNetworkBlockNode {
    public static final Identifier ID = id("drawer");
    public static final DrawerBlockNode INSTANCE = new DrawerBlockNode();

    private DrawerBlockNode() {
    }

    @Override
    public @NotNull Identifier getTypeId() {
        return ID;
    }

    @Override
    public void update(ServerWorld world, NodeHolder<BlockNode> node) {
        var pos = node.getPos();
        var state = world.getBlockState(pos);
        world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
    }
}

package fr.uranoscopidae.hatedmobs.common;

import fr.uranoscopidae.hatedmobs.client.gui.GuiEggSack;
import fr.uranoscopidae.hatedmobs.common.tileentities.TileEntityEggSack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler
{
    public static final int EGG_SACK_ID = 0;

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
            case EGG_SACK_ID :
                BlockPos.PooledMutableBlockPos pos = BlockPos.PooledMutableBlockPos.retain(x, y, z);
                TileEntity tileEntity = world.getTileEntity(pos);
                pos.release();
                if (tileEntity instanceof TileEntityEggSack)
                {
                    return new ContainerEggSack(player.inventory, (TileEntityEggSack)tileEntity);
                }
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
            case EGG_SACK_ID :
                BlockPos.PooledMutableBlockPos pos = BlockPos.PooledMutableBlockPos.retain(x, y, z);
                TileEntity tileEntity = world.getTileEntity(pos);
                pos.release();
                if (tileEntity instanceof TileEntityEggSack)
                {
                    return new GuiEggSack(player.inventory, (TileEntityEggSack)tileEntity);
                }
                break;
        }
        return null;
    }
}

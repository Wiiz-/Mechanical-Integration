package mod.mi.common.mechanical;

import java.util.ArrayList;
import java.util.List;

import mod.mi.common.tile.TileMechanical;

public class MechanicalNetwork
{

	public List<TileMechanical> nodes = new ArrayList<TileMechanical>();

	public float netPower = 0.0F;
	public float netTorque = 0.0F;
	public float netSpeed = 0.0F;

	public void syncNetwork()
	{

	}

	public void addNode(TileMechanical node)
	{
		this.nodes.add(node);
	}

	public void removeNode(TileMechanical node)
	{
		this.nodes.remove(node);
	}

	// Merges both networks into a new network
	public void mergeNetworks(MechanicalNetwork net1, MechanicalNetwork net2)
	{
		MechanicalNetwork mergedNet = new MechanicalNetwork();

		for (TileMechanical node : net1.nodes)
		{
			mergedNet.addNode(node);
			node.setNetwork(mergedNet);
		}

		for (TileMechanical node : net2.nodes)
		{
			mergedNet.addNode(node);
			node.setNetwork(mergedNet);
		}

		if (net1.netPower > net2.netPower)
		{
			mergedNet.netPower = net1.netPower;
			mergedNet.netSpeed = net1.netSpeed;
			mergedNet.netTorque = net1.netTorque;
		}
		else
		{
			mergedNet.netPower = net2.netPower;
			mergedNet.netSpeed = net2.netSpeed;
			mergedNet.netTorque = net2.netTorque;
		}

		mergedNet.syncNetwork();

		net1.nodes.clear();
		net2.nodes.clear();
	}

}

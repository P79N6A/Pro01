The rough notes you'll find here are my documentation of the fairly painful process of figuring out HOW to install a working, minimal SolrCloud (including Zookeeper).

The most recent notes about SolrCloud installation are in the Upgrade to 6_1_final.txt file.  
Interesting notes about networking can be found in the Instructions for cloning the VM.pdf file.

A number of these files have old information - start with the latest solr file (Upgrade to 6_1_final.txt) 
and the Zookeeper install file and the Instructions for cloning file.  With luck they've got all you need.

I used VirtualBox and Ubuntu.  It is assumed you know how to build an Ubuntu VM in VirtualBox - no instructions for that.

We start with the VM's built but NOTHING for SolrCloud installed.

We end up with 2 or 3 Solr machines, and 3 Zookeeper machines (the minimum allowd for a "quorum")

Please take note of the special instruction to use Zookeeper's "chroot" abilities to keep your Solr data OUT of the main "root" data structure on Zookeeper.
Trust me - you'll be glad you did.  Among other things it allows you to make use of different versions of Solr on the same Zookeeper cluster!

Remember - you have to have Zookeeper up and running first -- see the Zookeeper Installation and Disaster Recovery Documentation.pdf file.

Enjoy!

PS - you did read the part about the notes being "rough" right?
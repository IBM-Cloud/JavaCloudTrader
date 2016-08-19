# Sample Stock Trading application in Java EE

For more detailed instructions with images, click here: http://www.ibm.com/developerworks/cloud/library/cl-cloudtrader-app/index.html

## Prereqs
**Eclipse for Java EE Developers** http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/neonr

**Bluemix Eclipse plugin**
https://marketplace.eclipse.org/content/ibm-eclipse-tools-bluemix

## Step 1. Download Source

- Clone the source code locally.
    `git clone https://github.com/IBM-Bluemix/CloudTrader.git`
- Launch Eclipse. **File > Import > General > Existing Projects into Workspace > Select root directory > [Point to the CloudTrader src]**.
You should now see the CloudTrader project (with code) in your Project Explorer view.

## Step 2. Create a Bluemix server on Eclipse

- In Eclipse, **right-click the Servers** view and select **New** > **Server**. If you don't see the Servers view in Eclipse, make sure you are in the Java EE perspective and look in the bottom section for the Servers tab.
- In the Define a New Server window, expand the IBM folder, select **IBM Bluemix**, and click Next.
- **Enter your credentials** for your Bluemix account.
- Click on Validate Account, then click **Finish**.

## Step 3. Deploy the application to Bluemix

- You can now **drag and drop the CloudTrader project** onto the Bluemix server you just created.
- You will be presented with a wizard. Choose a unique name for your application to prevent name collisions on the ng.bluemix.net domain.
- On the next panel, you can select the URL and Memory information. Accept the defaults and click Next.
- On the Services selection panel, we will create the services the application needs. For now, we will only create the database service. Click on the **Add Service Icon** for the add service window icon near the top right to open the Add Service window. **Select dashDB**.
- For the Name, enter **TradeDataSource**. Bluemix will create the necessary configuration so that CloudTrader can look for this datasource with this JNDI name. 

Click **Finish** on both wizards. Within a few moments, your application should be deployed!

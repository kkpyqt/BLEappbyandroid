//package com.wehand.ui
//
//import android.os.Bundle
//import android.support.v4.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.wehand.R
//
//import android.widget.Toast
//import java.io.IOException;
//import java.io.InputStream;
////import java.io.OutputStream;
//import java.util.ArrayList;
//
//
//import kotlin.collections.Set
//import  kotlin.collections.List
//import java.util.UUID;
//
//import android.os.Handler;
//import android.os.Message;
//import android.app.Activity;
//import android.bluetooth.*
//import android.bluetooth.le.BluetoothLeScanner
//import android.bluetooth.le.ScanCallback
//import android.bluetooth.le.ScanResult
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Context.BLUETOOTH_SERVICE
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.content.pm.PackageManager
//import android.os.Build
//import android.util.Log
//import android.util.TimeUtils
////import kotlinx.android.synthetic.main.activity_kotlin.*
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Toast;
//import kotlinx.android.synthetic.main.fragment_ble.*
//import java.util.concurrent.TimeUnit
//
//class MeasureFragment : Fragment() {
//
//    companion object {
//        val TAG: String = MeasureFragment::class.java.simpleName
//        fun newInstance() = MeasureFragment()
//        //蓝牙设备的Service的UUID
//        val UUID_SERVICE = UUID.fromString("00001800-0000-1000-8000-00805f9b34fb")
//
//        //蓝牙设备的notify的UUID
//        val UUID_NOTIFY = UUID.fromString("00002a00-0000-1000-8000-00805f9b34fb")
//        val UUID_2 = UUID.fromString("00002a00-0000-1000-8000-00805f9b34fb")
//        val REQUEST_BT_ENABLE_CODE = 200
//        var mScanning: Boolean = false//是否正在搜索
//    }
//
//    // 获取到蓝牙适配器,创建BluetoothAdapter对象
//    private var mBluetoothAdapter: BluetoothAdapter? = null
//    private var mBluetoothGatt: BluetoothGatt? = null //GATT客户端
//    private var mBleScanner: BluetoothLeScanner? = null //BLE扫描器
//    //获得给定地址的远程蓝牙设备
//    private var mDevice: BluetoothDevice? = mBluetoothAdapter.getRemoteDevice("A2:C1:16:00:03:42")
//
//    val mLeScanCallback = BluetoothAdapter.LeScanCallback { device, rrsi, scanReocrd ->
//        if (device.address == "A2:C1:16:00:03:42") {
//            mDevice = device
//        }
//    }
//
//    //开始扫描前判断是否开启了蓝牙,flase 就停止扫描
//    fun scanLeDeviceWithBle(enable: Boolean = true) {
//        if (mBluetoothAdapter == null)
//            openBT()
//        if (mBluetoothAdapter?.isEnabled as Boolean) {
//            mBluetoothAdapter?.enable()
//        }
//        if (enable) {
//            mScanning = true
//            mBluetoothAdapter?.startLeScan(mLeScanCallback)
//            TimeUtilWithoutKotlin.Delay(8, TimeUnit.SECONDS).setTodo
//            {
//                mBluetoothAdapter?.stopLeScan(mLeScanCallback)
//                mScanning = false
//            }
//        } else {
////        停止扫描
//            mBluetoothAdapter?stopLeScan(mLeScanCallback)
//            mScanning = false
//
//        }
//
//    }
//
//    private fun startDiscover() {
//        val bluetoothAdaper = BluetoothAdapter.getDefaultAdapter()
//        bluetoothAdaper?.startDiscovery()
//    }
//
//    private inner class DeviceReceiver : BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent?) {
////            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            val action = intent.action
//            if (BluetoothDevice.ACTION_FOUND.equals(action())) {
//                val device = intent.getParcelableArrayExtra(BluetoothDevice.EXTRA_DEVICE)
//                Log.e("serveice ", "${ device}")
//
//
//            }
//
//        }
//    }
//
//    private val mBluetoothGattCallback = object : BluetoothGattCallback() {
//        fun onPhyUpdate(gatt: BluetoothGatt, txPhy: Int, rxPhy: Int, status: Int) {
//            super.onPhyUpdate(gatt, txPhy, rxPhy, status)
//        }
//
//        fun onPhyRead(gatt: BluetoothGatt, txPhy: Int, rxPhy: Int, status: Int) {
//            super.onPhyRead(gatt, txPhy, rxPhy, status)
//        }
//
//        override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
//            super.onConnectionStateChange(gatt, status, newState)
//            if (newState == BluetoothProfile.STATE_CONNECTED) {
//                //成功连接
//                outputLog("连接蓝牙服务成功")
//                mBluetoothGatt!!.discoverServices()//搜索服务器中的包含服务
//                outputLog("搜索外围服务")
//            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
//                //断开连接
//                outputLog("断开蓝牙服务")
//            }
//        }
//
//        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
//            super.onServicesDiscovered(gatt, status)
//            if (status == BluetoothGatt.GATT_SUCCESS) {
//                outputLog("成功搜索到服务")
//                //找到服务
//                //获取服务列表
//                mServiceList = gatt.services
//                //设置特性更改通知
//                setCharacteristicNotification()
//            } else {
//                outputLog("服务搜索失败")
//                Log.w(TAG, "onServicesDiscovered received: " + status)
//            }
//        }
//
//        override fun onCharacteristicRead(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
//            super.onCharacteristicRead(gatt, characteristic, status)
//            if (status == BluetoothGatt.GATT_SUCCESS) {
//                //读取特性
//                //characteristic.getValue();
//                outputLog("读取到特性：" + kotlin.String(characteristic.value))
//            }
//        }
//
//        override fun onCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
//            super.onCharacteristicWrite(gatt, characteristic, status)
//            if (status == BluetoothGatt.GATT_SUCCESS) {
//                //反写成功
//            }
//        }
//    }
//
//    fun connectWithBluetoothDevice() {
//        if (null == mDevice) {
////            toast("can not find device")
//            Toast.makeText("can not find device")
////            Toast.makeText(applicationContext, "can not find device", Toast.LENGTH_SHORT).show()
//            return
//        }
//        if (mScanning) {
//            scanLeDeviceWithBle(false)
//        }
//
//        mDevice?.connectGatt(this, false, mBluetoothGattCallback)
//        Toast.makeText("设备已连接")
//    }
//
//
//
//
//
//
//    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//            activity.title = getString(R.string.title_measure)
////        应用视图
//            val view = inflater?.inflate(R.layout.fragment_ble, container, false)
//            return view
//
//        }
//
////    fun isbleenable{
////
////        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
////            Toast.makeText(this, R.string.peripheral_is_not_supported, Toast.LENGTH_SHORT).show();
////            finish();
////        }
////    }
//
//
//    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        连接设备
//        connectWithBluetoothDevice()
//    }
//
//        //    初始化
//    private fun openBT() {
//            if (mBluetoothAdapter == null) {
//                /**这里和传统的蓝牙有什么区别呢？ */
////                val bluetoothManager = context.getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
//                val bluetoothManager = (BluetoothManager)getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
//                mBluetoothAdapter = bluetoothManager.adapter
//                //mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//                //如果调用scanBleDevices2()，请加上这句。 Call requires API level 21
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    mBleScanner = mBluetoothAdapter!!.bluetoothLeScanner
//                }
//            }
////        //1.设备不支持蓝牙，结束应用
////        if (mBluetoothAdapter == null) {
//////            super.getActivity().finish()
////            return
////        }
////        2.判断蓝牙是否打开
//            if (!mBluetoothAdapter!!.enable()) {
//                //没打开请求打开
//                val btEnable = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
//                startActivityForResult(btEnable, REQUEST_BT_ENABLE_CODE)
//                outputLog("正在打开蓝牙")
//            }
//        }
//
//    private fun outputLog(msg: String) {
////        if (mMessageAdapter != null) {
////            mMessageAdapter!!.addMessage(mDateFormat!!.format(System.currentTimeMillis()) + "  " + msg)
////        }
//            msg
//        }
//
//        /**
//         * 找到自己想要获取的特性，并设置更改通知
//         * 例如，服务里面提供了心率检测和血压监测，我现在只想获取心率
//         */
//    private fun setCharacteristicNotification() {
//            if (mBluetoothAdapter == null || mBluetoothGatt == null) {
//                Log.w(TAG, "BluetoothAdapter not initialized")
//                return
//            }
//            //找到对应服务
//            var characteristic: BluetoothGattCharacteristic? = null
//            for (s in mServiceList!!) {
//                if (s.uuid == GattServerActivity.TIME_SERVICE) {
//                    //找到对应服务的特性
//                    val cList = s.characteristics
//                    for (c in cList) {
//                        if (c.uuid == GattServerActivity.CURRENT_TIME) {
//                            //找出需要通知改变的特性
//                            characteristic = c
//                        }
//                    }
//                }
//            }
//            if (characteristic == null) {
//                return //服务中不包含我们需要获取的特性
//            }
//            //启动通知：BLE应用程序通常在设备上的特定特性发生变化时要求收到通知
//            //一旦为特性启用通知，如果远程设备上的特性发生变化，则触发回调onCharacteristicChanged()
//            mBluetoothGatt!!.setCharacteristicNotification(characteristic, true)
//            outputLog("开启特性变化通知成功")
//            // This is specific to Heart Rate Measurement.
//            //这里要对应我服务端所使用的UUID,详情请查看上一篇博客
//            //更改特性描述
//            if (GattServerActivity.CURRENT_TIME.equals(characteristic.uuid)) {
//                val descriptor = characteristic.getDescriptor(GattServerActivity.CLIENT_CONFIG)
//                descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
//                mBluetoothGatt!!.writeDescriptor(descriptor)
//            }
//
//            //然后读一下这个特性
//            mBluetoothGatt!!.readCharacteristic(characteristic)//会触发回调，这里就到回调中处理
//        }
//    }
//}
//
//
//
//
//

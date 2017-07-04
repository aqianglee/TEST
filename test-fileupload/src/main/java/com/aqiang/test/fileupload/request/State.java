package com.aqiang.test.fileupload.request;

public class State {
	private long uploadByte; // 已经上传的字节数，单位：字节
	private long fileSizeByte; // 所有文件的总长度，单位：字节
	private int fileIndex; // 正在上传第几个文件
	private int percent; // 上传百分比

	public State() {
		percent = 0;
	}

	public synchronized void setState(long uploadByte, long fileSizeByte, int fileIndex) {
		this.uploadByte = uploadByte;
		this.fileSizeByte = fileSizeByte;
		this.fileIndex = fileIndex;
		if ((Long.valueOf(uploadByte) * 100 / Long.valueOf(fileSizeByte) <= 100)) {
			percent = (int) (Long.valueOf(uploadByte) * 100 / Long.valueOf(fileSizeByte));
		}
	}

	@Override
	public String toString() {
		return "State [uploadByte=" + uploadByte + ", fileSizeByte=" + fileSizeByte + ", fileIndex=" + fileIndex
				+ ", percent=" + percent + "]";
	}

	public long getUploadByte() {
		return uploadByte;
	}

	public void setUploadByte(long uploadByte) {
		this.uploadByte = uploadByte;
	}

	public long getFileSizeByte() {
		return fileSizeByte;
	}

	public void setFileSizeByte(long fileSizeByte) {
		this.fileSizeByte = fileSizeByte;
	}

	public int getFileIndex() {
		return fileIndex;
	}

	public void setFileIndex(int fileIndex) {
		this.fileIndex = fileIndex;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

}
